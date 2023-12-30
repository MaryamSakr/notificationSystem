package com.notification.notification_services.orderManagement.orderModules;

import java.util.List;

public class CompoundOrder extends Order{
    private List<Order> orders;

    public CompoundOrder() {
        super();
    }


    public void setOrders(Order order) {
        this.orders.add(order);
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
