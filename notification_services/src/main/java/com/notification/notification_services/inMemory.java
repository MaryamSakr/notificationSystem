package com.notification.notification_services;


import com.notification.notification_services.ProductManagement.ProductModules.Product;
import com.notification.notification_services.ProductManagement.ProductBSL.ProductBSL;

import java.util.Vector;

public class inMemory {
    public static Vector<Product> products = new Vector<Product>();

    static {

        Product c1 = new Product("phone", 1, "111", "tec", 10000.0);
        products.add(c1);
        Product c2 = new Product("headphone", 2, "111", "tec", 450);
        products.add(c2);
        Product c3 = new Product("jacket", 3, "222", "clothes", 500);
        products.add(c3);
        Product c5 = new Product("hat", 5, "222", "clothes", 150);
        products.add(c5);
        Product c6 = new Product("fridge", 6, "333", "home cadgets", 15000);
        products.add(c6);

    }
}

