package com.notification.notification_services.notificationManagment.notificationController;

import com.notification.notification_services.notificationManagment.notificationBSL.PlacementBSL;
import com.notification.notification_services.notificationManagment.notificationModules.PlacementMod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlacementController {
    private final PlacementBSL p = new PlacementBSL();

    @PostMapping(value = "/placement")
    public String GenerateNote(@RequestBody PlacementMod place){
        p.setPlace(place);
        return p.generateTemplate();
    }
}
