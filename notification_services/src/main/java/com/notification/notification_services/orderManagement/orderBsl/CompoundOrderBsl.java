package com.notification.notification_services.orderManagement.orderBsl;

import com.notification.notification_services.orderManagement.orderModules.Order;

public class CompoundOrderBsl extends OrderBsl{

    @Override
    public double calcTotal(Order order) {
        return 0;
    }

    @Override
    public Order display(int id) {
        return null;
    }

    @Override
    public String addOrder(Order o) {
        return null;
    }

    @Override
    public String cancelOrder(int id) {
        return null;
    }
}
