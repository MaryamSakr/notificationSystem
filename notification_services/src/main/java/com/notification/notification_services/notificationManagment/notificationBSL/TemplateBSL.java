package com.notification.notification_services.notificationManagment.notificationBSL;

import com.notification.notification_services.customerMangment.customerModeles.Customer;
import com.notification.notification_services.inMemoeryCustomer;
import com.notification.notification_services.notificationManagment.notificationModules.TemplateMod;
import com.notification.notification_services.orderManagement.orderModules.Order;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;


@Service
public abstract class TemplateBSL {
     public static Map<Object, Integer> elementCountMap = new HashMap<>();
    public abstract String generateTemplate();
    public Order o;


    public Order getO() {
        return o;
    }

    public void setO(Order o) {
        this.o = o;
    }

    public static void countElements(String ele) {
        updateElementCount(ele);
    }

    private static void updateElementCount(String ele) {
        int count = elementCountMap.getOrDefault(ele, 0);
        elementCountMap.put(ele, count + 1);
    }

    public void popFromQueue(String note , String type){
        ChannelBSL p ;
        for (Customer customer : inMemoeryCustomer.customers) {
            if (o.getCustomerName().equals(customer.getUserName())) {
                p = customer.getChannel();
                p.send(note , o);
                break;
            }
        }
        countElements(type);
        TemplateMod.notifications.remove(note);
    }



    public Queue<String> display(){
       return TemplateMod.notifications;

    }


    public Map<Object, Integer> dis(){
        return elementCountMap;

    }


}
