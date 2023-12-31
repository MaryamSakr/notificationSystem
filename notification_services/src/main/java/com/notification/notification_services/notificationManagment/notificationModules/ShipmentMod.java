package com.notification.notification_services.notificationManagment.notificationModules;

import java.util.Random;

public class ShipmentMod extends TemplateMod{
    private String name;
    private String obj;
    private int Duration ;


    public ShipmentMod() {
        Random r = new Random();
        Duration = r.nextInt(1,10);
    }

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

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }
}
