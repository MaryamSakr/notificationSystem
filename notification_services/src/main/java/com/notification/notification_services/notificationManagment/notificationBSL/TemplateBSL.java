package com.notification.notification_services.notificationManagment.notificationBSL;

import com.notification.notification_services.notificationManagment.notificationModules.TemplateMod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Service
public abstract class TemplateBSL {
     public static Map<Object, Integer> elementCountMap = new HashMap<>();
    public abstract String generateTemplate();


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
        return ch.send(note);
    }



    public Queue<String> display(){
       return TemplateMod.notifications;

    }



}
