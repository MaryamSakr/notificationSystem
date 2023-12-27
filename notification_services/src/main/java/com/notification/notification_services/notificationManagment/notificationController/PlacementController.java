package com.notification.notification_services.notificationManagment.notificationController;

import com.notification.notification_services.notificationManagment.notificationBSL.PlacementBSL;
import com.notification.notification_services.notificationManagment.notificationModules.TemplateMod;
import org.springframework.web.bind.annotation.*;


@RestController
public class PlacementController {
    private final PlacementBSL p = new PlacementBSL();

    @PostMapping(value = "/placement")
    public String GenerateNote(@RequestBody TemplateMod t){
        return p.generateTemplate(t);
    }
}
