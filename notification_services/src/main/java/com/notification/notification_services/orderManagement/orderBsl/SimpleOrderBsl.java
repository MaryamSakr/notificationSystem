package com.notification.notification_services.orderManagement.orderBsl;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
import com.notification.notification_services.orderManagement.orderModules.Order;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import org.springframework.stereotype.Service;

@Service
public class SimpleOrderBsl extends OrderBsl{
    private SimpleOrder simpleOrder;
    SimpleOrderBsl(){
        this.simpleOrder = new SimpleOrder();
    }

    @Override
    public double calcTotal(Order order) {
        this.simpleOrder = (SimpleOrder) order;
        double price =0;
        for (Product pro:simpleOrder.getProducts()) {
            price = price + pro.getPrice();
        }
        return price;
    }
}
