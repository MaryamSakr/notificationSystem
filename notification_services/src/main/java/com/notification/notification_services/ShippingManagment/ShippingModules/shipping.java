package com.notification.notification_services.ShippingManagment.ShippingModules;

import com.notification.notification_services.ProductManagement.ProductModules.Product;
import com.notification.notification_services.customerMangment.customerModeles.Location;

public class shipping {
    public Location location;
    public double fees;


    public double calcFees() {

       if (location.getCity() =="cairo")
       {
           fees =10;
       }
       else if (location.getCity() =="alexanderia")
       {
           fees=40;
       }
      else
       {
           fees=100;
       }
      return fees;
   }

    public void setLocation(Location location) {
        this.location = location;
    }
}
