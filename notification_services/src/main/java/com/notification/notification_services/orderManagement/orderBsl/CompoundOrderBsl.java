package com.notification.notification_services.orderManagement.orderBsl;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
import com.notification.notification_services.ShippingManagment.ShippingModules.shipping;
import com.notification.notification_services.customerMangment.customerModeles.Customer;
import com.notification.notification_services.inMemoeryCustomer;
import com.notification.notification_services.inMemory;
import com.notification.notification_services.inMemoryOrder;
import com.notification.notification_services.notificationManagment.notificationBSL.PlacementBSL;
import com.notification.notification_services.orderManagement.orderModules.CompoundOrder;
import com.notification.notification_services.orderManagement.orderModules.Order;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import java.util.ArrayList;
public class CompoundOrderBsl extends OrderBsl{
    private CompoundOrder compoundOrder;
    boolean flag = false;
    public CompoundOrderBsl(){
        this.compoundOrder = new CompoundOrder();
    }
    public CompoundOrderBsl(CompoundOrder compoundOrder){
        this.compoundOrder=compoundOrder;
    }
    @Override
    public double calcTotal() {
        shipping ship = new shipping();
        double price =0,shipPrice=0;
        String area = null;
        for (Customer customer : inMemoeryCustomer.customers) {
            if(compoundOrder.getCustomerName().equals(customer.getUserName())){
                this.flag =true;
                area = customer.getLocation().getArea();
                ship.setLocation(customer.getLocation());
                shipPrice = ship.calcFees();
            }
        }
        compoundOrder.setShipFees(shipPrice);
        if(!this.flag){
            return 0;
        }
        for (Order o : compoundOrder.getOrders()) {
            SimpleOrder simpleOrder = (SimpleOrder) o;
            double priceOne=0;
            for (Product pro: inMemory.products) {
                for (Product product : simpleOrder.getProducts()) {
                    if (product.getName().equals(pro.getName())) {
                        product.setSerialNumber(pro.getSerialNumber());
                        product.setCategory(pro.getCategory());
                        product.setPrice(pro.getPrice());
                        product.setVendorId(pro.getVendorId());
                        price = price + pro.getPrice();
                        priceOne = priceOne + pro.getPrice();
                    }
                }
            }
            for (Customer customer : inMemoeryCustomer.customers) {
                if(simpleOrder.getCustomerName().equals(customer.getUserName())){
                    if(!area .equals(customer.getLocation().getArea())){
                        return -1;
                    }
                    if(customer.getBalance() < (shipPrice / compoundOrder.getOrders().size() + priceOne)){
                        return -2;
                    }
                    customer.setBalance(customer.getBalance() - (shipPrice / compoundOrder.getOrders().size() + priceOne));
                }
            }
            o.setShipFees((shipPrice / compoundOrder.getOrders().size()));
            o.setTotalPrice(priceOne + o.getShipFees());
        }
        return price + shipPrice;
    }
    public void note(CompoundOrder o){
        PlacementBSL place = new PlacementBSL();
        place.setO(o);
        place.generateTemplate();
    }
    @Override
    public String addOrder(Order order) {
        this.compoundOrder = (CompoundOrder) order;
        if(calcTotal() == -1){
            return "the area is diffrent";
        }
        if(calcTotal() == -2){
            return "one customer balance is less than his order cost";
        }
        compoundOrder.setTotalPrice(calcTotal());
        if(!this.flag){
            return compoundOrder.getCustomerName()+" doesn't exist";
        }
        compoundOrder.setId(inMemoryOrder.orders.get(inMemoryOrder.orders.size()-1).getId() +1 );
        for (Order o : compoundOrder.getOrders()) {
            o.setId(compoundOrder.getId());
        }
        note(compoundOrder);
        inMemoryOrder.orders.add(compoundOrder);
        return "Added successfully";
    }
}
