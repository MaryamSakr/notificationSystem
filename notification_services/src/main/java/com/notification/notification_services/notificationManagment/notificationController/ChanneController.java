package com.notification.notification_services.notificationManagment.notificationController;

import com.notification.notification_services.notificationManagment.notificationBSL.EmailBSL;
import com.notification.notification_services.notificationManagment.notificationBSL.SmsBSL;
import com.notification.notification_services.notificationManagment.notificationBSL.TemplateBSL;
import com.notification.notification_services.notificationManagment.notificationModules.ChannelMod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public abstract class ChanneController {

    @GetMapping(value = "/mailStat")
    public Map<Object, Integer> Mailstat(){
        return EmailBSL.EmailsCountMap;
    }

    @GetMapping(value = "/smsStat")
    public Map<Object, Integer> SmsState(){
        return SmsBSL.SmsCountMap;
    }

}
