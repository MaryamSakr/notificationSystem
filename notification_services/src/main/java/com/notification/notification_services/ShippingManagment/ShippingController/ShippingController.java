package com.notification.notification_services.ShippingManagment.ShippingController;

import com.notification.notification_services.ShippingManagment.ShippingModules.shipping;
import com.notification.notification_services.customerMangment.customerModeles.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingController {
    public Location location;
    private shipping ship;
    @GetMapping("/shipfees/{area}/{street}/{city}")
    public double shippingfees ( @PathVariable("area") String area,
                                 @PathVariable("street") String street,
                                 @PathVariable("city") String city)
    {
        Location location = new Location(area, street, city);
        ship.setLocation(location);
        return ship.calcFees();
    }
}



//    @GetMapping("/shipfees/{area}/{street}/{city}")
//    public double shippingfees (@PathVariable("area") String area,@PathVariable("street") String street,@PathVariable("city") String city)
//    {
//        location.setArea(area);
//        location.setStreet(street);
//        location.setCity(city);
//        return ship.calcFees(location);
//    }


//@RestController
//public class ShippingController {
//    @GetMapping("/shipfees/{location}")
//    public shipping shippingfees (@PathVariable("location")  String location)
//    {
//        return shipping.calcFees(location);
//    }
//}




