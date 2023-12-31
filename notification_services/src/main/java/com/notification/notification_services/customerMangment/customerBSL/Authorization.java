package com.notification.notification_services.customerMangment.customerBSL;
import com.notification.notification_services.customerMangment.customerModeles.Customer;
import com.notification.notification_services.inMemoeryCustomer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Authorization {

    public String createAccount(Customer customer){

        for(Customer custmers: inMemoeryCustomer.customers){
            if (custmers.getUserName().equals(customer.getUserName())){
                //System.out.println("this user name already exist");
                return "this user name already exists";
            }
        }
        inMemoeryCustomer.customers.add(customer);
        return "added successfully";


    }
    public String login(String userName,String password){
        for(Customer custmer:inMemoeryCustomer.customers) {

            if (custmer.getUserName().equals(userName) ){
                if (custmer.getPassword().equals(password)) {
                    System.out.println("successful login ");
                    return "successful login ";
                }
                return "wrong password";
            }
        }
        return "not exist";
    }
}

