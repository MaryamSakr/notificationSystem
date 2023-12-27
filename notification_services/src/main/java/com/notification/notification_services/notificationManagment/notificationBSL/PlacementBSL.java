package com.notification.notification_services.notificationManagment.notificationBSL;

import com.notification.notification_services.notificationManagment.notificationModules.TemplateMod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service

public class PlacementBSL extends TemplateBSL{
    static int count=0;

    public PlacementBSL() {}

    @Override

    public String generateTemplate(TemplateMod T) {
        String notification;
        notification = "Dear "+T.getName()+" , your booking of the " +T.getObj()+ " is confirmed. thanks for using our store :)";
        TemplateMod.notifications.add(notification);
        count++;
        return notification;
    }
}
