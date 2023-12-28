package com.notification.notification_services.orderManagement.orderBsl;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
import com.notification.notification_services.orderManagement.orderModules.Order;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public abstract class OrderBsl {
    protected List<Order> orders;
    OrderBsl(){
        List<Product> products = new ArrayList<>();
       Product product = new Product("hh",5,"8","geef",200);
       products.add(product);
        Order o=new SimpleOrder(1,2,products);
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
    public String addOrder(Order o){
        for(Order order:this.orders) {
            if(o.getId()==order.getId()){
                return "This order already exist";
            }
        }
        o.setTotalPrice(calcTotal(o));
        orders.add(o);
        return "Added successfully";
    }
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
