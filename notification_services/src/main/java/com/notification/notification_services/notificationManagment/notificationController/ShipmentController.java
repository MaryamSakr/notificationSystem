package com.notification.notification_services.notificationManagment.notificationController;
import com.notification.notification_services.notificationManagment.notificationBSL.ShipmentBSL;
import com.notification.notification_services.notificationManagment.notificationModules.ShipmentMod;
import org.springframework.web.bind.annotation.*;


@RestController
public class ShipmentController {
    private final ShipmentBSL s = new ShipmentBSL();

    @PostMapping(value = "/Shipment")
    public String GenerateNote(@RequestBody ShipmentMod sh){
        s.setSh(sh);
        return s.generateTemplate();
    }
}
