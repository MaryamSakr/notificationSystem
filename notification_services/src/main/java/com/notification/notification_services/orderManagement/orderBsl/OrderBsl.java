package com.notification.notification_services.orderManagement.orderBsl;
import com.notification.notification_services.orderManagement.orderModules.Order;
import com.notification.notification_services.inMemoryOrder;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import org.springframework.stereotype.Service;
@Service
public abstract class OrderBsl {
    public abstract double calcTotal();
    public Order getOrder(int id) {
        for(Order order:inMemoryOrder.orders) {
            if(id == order.getId()){
                return order;
            }
        }
        return null;
    }
    public abstract String addOrder(Order o);
    public String cancelOrder(int id) {
        for(Order order:inMemoryOrder.orders) {
            if(id == order.getId()){
                inMemoryOrder.orders.remove(order);
                return "deleted successfully";
            }
        }
        return "This order doesn't exist";
    }
}
