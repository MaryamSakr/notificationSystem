package com.notification.notification_services.ProductManagement.ProductModules;

import java.util.Vector;

public class Product {

    public int serialNumber;

    //    public String serialNumber;
    public String name;
    public String vendorId;
    public String category;
    public double price;

    public Product(String name, int serialNumber, String vendorId, String category, double price) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.vendorId = vendorId;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


//    public static Vector<Product> products = new Vector<Product>();
//
//    static {
//
//        Product c = new Product("phone", 1, "111", "tec", 10000.0);
//        products.add(c);
//        Product c2 = new Product("headphone", 2, "111", "tec", 450);
//        products.add(c2);
//        Product c3 = new Product("jacket", 3, "222", "clothes", 500);
//        products.add(c3);
//        Product c4 = new Product("headphone", 4, "222", "tec", 450);
//        products.add(c4);
//
//    }
}