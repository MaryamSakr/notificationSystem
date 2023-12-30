package com.notification.notification_services;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
import com.notification.notification_services.orderManagement.orderModules.Order;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import java.util.ArrayList;
public class inMemoryOrder {
    public static ArrayList<Order> orders =new ArrayList<>();
    static {
        ArrayList<Product> products = new ArrayList<>();
        products.add(inMemory.products.get(0));
        Order o1 = new SimpleOrder( "Alaa", 10010, 10, products);
        o1.setId(1);
        orders.add(o1);
        ArrayList<Product> products1 = new ArrayList<>();
        products1.add(inMemory.products.get(1));
        Order o2 = new SimpleOrder( "Maryam", 460, 10, products);
        o2.setId(2);
        orders.add(o2);
    }
}
