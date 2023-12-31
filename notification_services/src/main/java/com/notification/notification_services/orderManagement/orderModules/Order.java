package com.notification.notification_services.orderManagement.orderModules;
public abstract class Order {
    protected int id;
    protected double shipFees;
    protected double totalPrice;
    protected String customerName;
    Order(){
        this.totalPrice = 0;
        this.shipFees = 0;
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
    public  void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;}


}
