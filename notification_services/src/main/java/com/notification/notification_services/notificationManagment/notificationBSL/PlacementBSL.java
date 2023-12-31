package com.notification.notification_services.notificationManagment.notificationBSL;

import com.notification.notification_services.notificationManagment.notificationModules.PlacementMod;
import com.notification.notification_services.notificationManagment.notificationModules.TemplateMod;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Service

public class PlacementBSL extends TemplateBSL{
    PlacementMod place = new PlacementMod();

    public PlacementBSL() {}

    public void setPlace(PlacementMod place) {
        this.place = place;
    }

    @Override

    public String generateTemplate() {
        String notification;
        notification = "Dear "+place.getName()+" , your booking of the " +place.getObj()+ " is confirmed and you will get notification when it shipped soon";
        TemplateMod.notifications.add(notification);
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(() -> popFromQueue(notification , "Placement"), 10, TimeUnit.SECONDS);
        return notification;
    }


}
