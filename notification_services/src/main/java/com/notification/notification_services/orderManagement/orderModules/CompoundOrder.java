package com.notification.notification_services.orderManagement.orderModules;
import com.notification.notification_services.customerMangment.customerModeles.Customer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class CompoundOrder extends Order{
    private List<Order> orders;

    public CompoundOrder() {
    }
    public CompoundOrder(int totalPrice, int shipFees,List<Order> orders ){
        this.totalPrice = totalPrice;
        this.shipFees = shipFees;
        this.orders=orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = (orders != null) ? new ArrayList<>(orders) : new ArrayList<>();    }
    public List<Order> getOrders() {
        return orders;
    }
}