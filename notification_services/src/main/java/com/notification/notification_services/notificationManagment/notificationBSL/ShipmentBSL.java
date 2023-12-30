package com.notification.notification_services.notificationManagment.notificationBSL;

import com.notification.notification_services.notificationManagment.notificationModules.ShipmentMod;
import com.notification.notification_services.notificationManagment.notificationModules.TemplateMod;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service

public class ShipmentBSL extends TemplateBSL{

    ShipmentMod sh = new ShipmentMod();

    public ShipmentBSL() {}

    public ShipmentMod getSh() {
        return sh;
    }

    public void setSh(ShipmentMod sh) {
        this.sh = sh;
    }

    @Override

    public String generateTemplate() {
        String notification;
        notification = "Dear "+sh.getName()+" , your order of the " +sh.getObj()+ " is Shipment and it will arrive after " + sh.getDuration() + " Days";
        TemplateMod.notifications.add(notification);
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(() -> popFromQueue(notification , "Shipment"), 10, TimeUnit.SECONDS);
        return notification;
    }
}
