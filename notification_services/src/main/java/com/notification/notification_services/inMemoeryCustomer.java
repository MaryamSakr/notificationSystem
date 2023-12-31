package com.notification.notification_services;
import com.notification.notification_services.customerMangment.customerModeles.Customer;
import com.notification.notification_services.customerMangment.customerModeles.Location;
import com.notification.notification_services.notificationManagment.notificationBSL.EmailBSL;
import com.notification.notification_services.notificationManagment.notificationBSL.SmsBSL;

import java.util.ArrayList;
public class inMemoeryCustomer {
    public static ArrayList<Customer> customers =new ArrayList<>();
    static {
        Location l1 = new Location("Faisal","El-Eshrin", "cairo");
        Customer c1 = new Customer( "alaa.hossam.2013@gmail.com", "Alaa", "172003*Al","01276012577",1000,l1 , new SmsBSL());
        customers.add(c1);
        Location l2 = new Location("Imbaba","El-Mahata", "cairo");
        Customer c2 = new Customer( "MaryamSakr@gmail.com", "Maryam", "19102002*Ma" , "01122143218" , 500,l2 , new EmailBSL());
        customers.add(c2);
    }
}
