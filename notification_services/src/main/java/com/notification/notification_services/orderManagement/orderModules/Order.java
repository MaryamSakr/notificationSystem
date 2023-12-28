package com.notification.notification_services.orderManagement.orderModules;
import java.util.ArrayList;
import java.util.List;

public abstract class Order {
    protected int id;
    protected double shipFees;
    protected double totalPrice;

    Order(int id){
        this.id = id;
        this.totalPrice = 0;
        this.shipFees = 0;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setShipFees(double shipFees) {
        this.shipFees = shipFees;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public double getShipFees() {
        return shipFees;
    }
    public int getId() {
        return id;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

}
