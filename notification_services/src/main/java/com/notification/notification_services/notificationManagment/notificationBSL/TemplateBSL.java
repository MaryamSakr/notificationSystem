package com.notification.notification_services.notificationManagment.notificationBSL;

import com.notification.notification_services.notificationManagment.notificationModules.TemplateMod;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;


@Service
public abstract class TemplateBSL {
     public static Map<Object, Integer> elementCountMap = new HashMap<>();
    public abstract String generateTemplate();
    public SimpleOrder s;


    public static void countElements(String ele) {
        updateElementCount(ele);
    }

    private static void updateElementCount(String ele) {
        int count = elementCountMap.getOrDefault(ele, 0);
        elementCountMap.put(ele, count + 1);
    }

    public String popFromQueue(String note , String type){
        ChannelBSL ch = new EmailBSL();
        countElements(type);
        TemplateMod.notifications.remove(note);
        return ch.send(note , s);
    }



    public Queue<String> display(){
       return TemplateMod.notifications;

    }


    public Map<Object, Integer> dis(){
        return elementCountMap;

    }


}
