package com.notification.notification_services.notificationManagment.notificationController;


import com.notification.notification_services.notificationManagment.notificationBSL.ShipmentBSL;
import com.notification.notification_services.notificationManagment.notificationBSL.TemplateBSL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Queue;

@RestController
public class TemplateController {
    private  final TemplateBSL t = new ShipmentBSL();

    @GetMapping(value = "/Display")
    public Queue<String> GenerateNote(){
        return t.display();
    }

    @GetMapping(value = "/Dis")
    public Map<Object, Integer> dis(){
        return TemplateBSL.elementCountMap;

    }


}
