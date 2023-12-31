package com.notification.notification_services.orderManagement.orderModules;
import com.notification.notification_services.customerMangment.customerModeles.Customer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class CompoundOrder extends Order{
    private List<SimpleOrder> orders;

    public CompoundOrder() {
        super();
    }
    public CompoundOrder(String customerName,int totalPrice, int shipFees,List<SimpleOrder> orders ){
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.shipFees = shipFees;
        this.orders=(orders != null) ? new ArrayList<>(orders) : new ArrayList<>(); ;
    }
    public void setOrders(List<SimpleOrder> orders) {
        this.orders = (orders != null) ? new ArrayList<>(orders) : new ArrayList<>();    }
    public List<SimpleOrder> getOrders() {
        return orders;
    }

    public  void setTotalPrice(double totalPrice) {
        super.setTotalPrice(totalPrice);
    }

    public String getCustomerName() {
        return customerName;
    }
}