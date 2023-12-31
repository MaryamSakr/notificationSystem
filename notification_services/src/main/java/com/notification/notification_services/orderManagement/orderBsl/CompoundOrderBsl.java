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
        double price =0,shipPrice=0;
        for (Order o : compoundOrder.getOrders()) {
            SimpleOrder simpleOrder = (SimpleOrder) o;
            for (Customer customer : inMemoeryCustomer.customers) {
                this.flag=false;
                if(simpleOrder.getCustomerName().equals(customer.getUserName()) && shipPrice == 0){
                    this.flag =true;
                    ship.setLocation(customer.getLocation());
                    shipPrice = ship.calcFees();
                    customer.setBalance(customer.getBalance()-(shipPrice /compoundOrder.getOrders().size()));
                } else if (shipPrice != 0 && simpleOrder.getCustomerName().equals(customer.getUserName())) {
                    flag = true;
                    customer.setBalance(customer.getBalance() - (shipPrice /compoundOrder.getOrders().size()));
                }
            }
            if(!this.flag){
                return 0;
            }
            simpleOrder.setShipFees((shipPrice /compoundOrder.getOrders().size()));
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
        return price + shipPrice;
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
            simpleOrder.setTotalPrice(calcTotal());
        }
        compoundOrder.setId(inMemoryOrder.orders.get(inMemoryOrder.orders.size()-1).getId() +1 );
        inMemoryOrder.orders.add(compoundOrder);
        return "Added successfully";
    }


}
