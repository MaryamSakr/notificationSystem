package com.notification.notification_services;
import com.notification.notification_services.customerMangment.customerModeles.Customer;
import com.notification.notification_services.customerMangment.customerModeles.Location;
import java.util.ArrayList;
public class inMemoeryCustomer {
    public static ArrayList<Customer> customers =new ArrayList<>();
    static {
        Location l1 = new Location("Faisal","El-Eshrin", "cairo");
        Customer c1 = new Customer( "alaa.hossam.2013@gmail.com", "Alaa", "172003*Al","01276012577",1000,l1 );
        customers.add(c1);
        Location l2 = new Location("Imbaba","El-Mahata", "cairo");
        Customer c2 = new Customer( "MaryamSakr@gmail.com", "Maryam", "19102002*Ma" , "01122143218" , 500,l2 );
        customers.add(c2);
    }
}
