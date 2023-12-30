package com.notification.notification_services.orderManagement.orderBsl;
import com.notification.notification_services.inMemoryOrder;
import com.notification.notification_services.orderManagement.orderModules.CompoundOrder;
import com.notification.notification_services.orderManagement.orderModules.Order;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import java.util.ArrayList;
public class CompoundOrderBsl extends OrderBsl{
    private CompoundOrder compoundOrder;
    CompoundOrderBsl(){
        this.compoundOrder = new CompoundOrder();
    }
    CompoundOrderBsl(CompoundOrder compoundOrder){
        this.compoundOrder=compoundOrder;
    }
    @Override
    public double calcTotal() {
        double price = 0;
        for (Order order:compoundOrder.getOrders()) {
            price += calcTotal();
        }
        return price;
    }
    @Override
    public String addOrder(Order order) {
        this.compoundOrder = (CompoundOrder) order;
        for (Order o:compoundOrder.getOrders()) {
            SimpleOrderBsl simpleOrderBsl = new SimpleOrderBsl((SimpleOrder) o);
            simpleOrderBsl.addOrder(o);
        }
        return "";
    }


}
