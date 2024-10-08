package com.notification.notification_services.orderManagement.orderBsl;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
import com.notification.notification_services.ShippingManagment.ShippingModules.shipping;
import com.notification.notification_services.customerMangment.customerModeles.Customer;
import com.notification.notification_services.inMemoeryCustomer;
import com.notification.notification_services.inMemory;
import com.notification.notification_services.inMemoryOrder;
import com.notification.notification_services.notificationManagment.notificationBSL.PlacementBSL;
import com.notification.notification_services.notificationManagment.notificationBSL.ShipmentBSL;
import com.notification.notification_services.orderManagement.orderModules.Order;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class SimpleOrderBsl extends OrderBsl{
    private SimpleOrder simpleOrder ;
    boolean flag = false;
    public SimpleOrderBsl() {
        this.simpleOrder=new SimpleOrder();
    }
    public SimpleOrderBsl(SimpleOrder simpleOrder){
        super();
        this.simpleOrder = simpleOrder;
    }
    @Override
    public double calcTotal() {
        shipping ship = new shipping();
        double price =0,shipPrice=0;
        for (Product pro: inMemory.products) {
            for (Product product : simpleOrder.getProducts()) {
                if (product.getName().equals(pro.getName())) {
                    product.setSerialNumber(pro.getSerialNumber());
                    product.setCategory(pro.getCategory());
                    product.setPrice(pro.getPrice());
                    product.setVendorId(pro.getVendorId());
                    price = price + pro.getPrice();
                }
            }
        }
        for (Customer customer : inMemoeryCustomer.customers) {
            if(simpleOrder.getCustomerName().equals(customer.getUserName())){
                this.flag =true;
                ship.setLocation(customer.getLocation());
                shipPrice = ship.calcFees();
                if(shipPrice+price > customer.getBalance()){
                    return -1;
                }
                customer.setBalance(customer.getBalance() - (price+shipPrice));
            }
        }
        if(!this.flag){
            return 0;
        }
        simpleOrder.setShipFees(shipPrice);
        return price;
    }

    public void note(SimpleOrder o){
        PlacementBSL place = new PlacementBSL();
        place.setO(o);
        place.generateTemplate();
    }
    @Override
    public String addOrder(Order o){

        simpleOrder = (SimpleOrder) o;
        if(calcTotal() == -1){
            return "the balance is less than the order cost";
        }
        simpleOrder.setTotalPrice(calcTotal());
        if(!this.flag){
            return simpleOrder.getCustomerName()+" doesn't exist";
        }
        simpleOrder.setId(inMemoryOrder.orders.get(inMemoryOrder.orders.size()-1).getId() +1 );
            note(simpleOrder);

        inMemoryOrder.orders.add(simpleOrder);


        return "Added successfully";
    }

}



