package com.notification.notification_services.orderManagement.orderBsl;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
import com.notification.notification_services.orderManagement.orderModules.Order;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import org.springframework.stereotype.Service;
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
                return order;
            }
        }
        return null;
    }
    public abstract String addOrder(Order o);
    public String cancelOrder(int id) {
        for(Order order:this.orders) {
            if(id == order.getId()){
                orders.remove(order);
                return "deleted successfully";
            }
        }
        return "This order doesn't exist";
    }
}
