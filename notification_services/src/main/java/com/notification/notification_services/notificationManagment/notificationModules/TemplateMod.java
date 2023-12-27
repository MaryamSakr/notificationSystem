package com.notification.notification_services.notificationManagment.notificationModules;

import java.util.LinkedList;
import java.util.Queue;

public class TemplateMod {
    public static Queue<String> notifications = new LinkedList<>();
    private String name;
    private String obj;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }
}
