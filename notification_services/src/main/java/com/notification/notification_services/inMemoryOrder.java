package com.notification.notification_services;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
import com.notification.notification_services.customerMangment.customerModeles.Customer;
import com.notification.notification_services.orderManagement.orderModules.CompoundOrder;
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
        Order o2 = new SimpleOrder( "Maryam", 460, 10, products1);
        o2.setId(2);
        orders.add(o2);
        ArrayList<Order> orders1 = new ArrayList<>();
        orders1.add(orders.get(1));
        Order o3 = new CompoundOrder( 460, 10, orders1 );
        o3.setId(3);
        orders.add(o3);
        ArrayList<Order> orders2 = new ArrayList<>();
        orders2.add(orders.get(2));
        Order o4 = new CompoundOrder( 460, 10, orders2 );
        o4.setId(4);
        orders.add(o4);
    }
}
