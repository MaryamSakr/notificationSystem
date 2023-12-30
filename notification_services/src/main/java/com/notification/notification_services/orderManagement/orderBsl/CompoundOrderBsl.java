package com.notification.notification_services.orderManagement.orderBsl;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
import com.notification.notification_services.ShippingManagment.ShippingModules.shipping;
import com.notification.notification_services.customerMangment.customerModeles.Customer;
import com.notification.notification_services.inMemoeryCustomer;
import com.notification.notification_services.inMemory;
import com.notification.notification_services.inMemoryOrder;
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
        double price =0;
        for (Order o : compoundOrder.getOrders()) {
            SimpleOrder simpleOrder = (SimpleOrder) o;
            for (Customer customer : inMemoeryCustomer.customers) {
                if(simpleOrder.getCustomerName().equals(customer.getUserName())){
                    this.flag =true;
                    ship.setLocation(customer.getLocation());
                    price = ship.calcFees();
                    customer.setBalance(customer.getBalance()-price);
                    break;
                }
            }
            if(!this.flag){
                return 0;
            }
            simpleOrder.setShipFees(price);
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
        }
        return price;
    }
    @Override
    public String addOrder(Order order) {
        this.compoundOrder = (CompoundOrder) order;
        for (Order o : compoundOrder.getOrders()) {
            SimpleOrder simpleOrder = (SimpleOrder) o;
            simpleOrder.setTotalPrice(calcTotal());
            if(!this.flag){
                return simpleOrder.getCustomerName()+" doesn't exist";
            }
            simpleOrder.setId(inMemoryOrder.orders.get(inMemoryOrder.orders.size()-1).getId() +1 );
            System.out.println(simpleOrder.getId());
            inMemoryOrder.orders.add(o);
            o.setTotalPrice(calcTotal());
            inMemoryOrder.orders.add(o);
        }
        return "Added successfully";
    }


}
