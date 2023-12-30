package com.notification.notification_services.orderManagement.orderBsl;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
import com.notification.notification_services.orderManagement.orderModules.Order;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import org.springframework.stereotype.Service;
import com.notification.notification_services.inMemory;

@Service
public class SimpleOrderBsl extends OrderBsl{

    protected SimpleOrder simpleOrder;
    @Override
    public double calcTotal(Order order) {
        this.simpleOrder = (SimpleOrder) order;
        double price =0;
        for (Product pro: inMemory.products) {
            for (String name : simpleOrder.getProducts()) {
                if (name .equals(pro.getName())) {
                    price = price + pro.getPrice();
                }
            }
        }
        return price;
    }

    @Override
    public String addOrder(Order o) {
        for(Order order:this.orders) {
            if(o.getId()==order.getId()){
                return "This order already exist";
            }
        }
        o.setTotalPrice(calcTotal(o));
        orders.add(o);
        return "Added successfully";
    }
}
