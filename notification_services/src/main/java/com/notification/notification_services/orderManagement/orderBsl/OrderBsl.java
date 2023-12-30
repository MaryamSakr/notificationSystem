package com.notification.notification_services.orderManagement.orderBsl;
import com.notification.notification_services.orderManagement.orderModules.Order;
import com.notification.notification_services.inMemoryOrder;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
@Service
public abstract class OrderBsl {
    public abstract double calcTotal();
    public Order getOrder(int id) {
        for(Order order:inMemoryOrder.orders) {
            if(id == order.getId()){
=======
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public abstract class OrderBsl {
    protected List<Order> orders;
    OrderBsl(){
        List<String> pro=new ArrayList<>();
        pro.add("phone");
        Order o=new SimpleOrder(1,2,pro);
        orders =new ArrayList<>();
        addOrder(o);
    }
    public abstract double calcTotal(Order order);
    public Order display(int id) {
        for(Order order:this.orders) {
            if(id==order.getId()){
>>>>>>> e2e9aec172082c7213142bcd70b6677aebdae11f
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
