package com.notification.notification_services.orderManagement.orderBsl;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
import com.notification.notification_services.ShippingManagment.ShippingModules.shipping;
import com.notification.notification_services.customerMangment.customerModeles.Customer;
import com.notification.notification_services.inMemoeryCustomer;
import com.notification.notification_services.inMemory;
import com.notification.notification_services.inMemoryOrder;
import com.notification.notification_services.orderManagement.orderModules.Order;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import org.springframework.stereotype.Service;
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
        double price =0;
        for (Customer customer : inMemoeryCustomer.customers) {
            if(simpleOrder.getCustomerName().equals(customer.getUserName())){
                this.flag =true;
                ship.setLocation(customer.getLocation());
                price = ship.calcFees();
                customer.setBalance(customer.getBalance()-price);
            }
        }
        if(!this.flag){
            return 0;
        }
        simpleOrder.setShipFees(price);
        for (Product pro: inMemory.products) {
            for (Product product : simpleOrder.getProducts()) {
                if (product.getName().equals(pro.getName())) {
                    price = price + pro.getPrice();
                }
            }
        }
        return price;
    }
    @Override
    public String addOrder(Order o){
        simpleOrder = (SimpleOrder) o;
        simpleOrder.setTotalPrice(calcTotal());
        if(!this.flag){
            return simpleOrder.getCustomerName()+" doesn't exist";
        }
        simpleOrder.setId(inMemoryOrder.orders.get(inMemoryOrder.orders.size()-1).getId() +1 );
        System.out.println(simpleOrder.getId());
        inMemoryOrder.orders.add(o);
        o.setTotalPrice(calcTotal());
        inMemoryOrder.orders.add(o);
        return "Added successfully";
    }
}
