package com.notification.notification_services.ProductManagement.ProductModules;

import java.util.Vector;

public class Product {

    public int serialNumber;
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

}