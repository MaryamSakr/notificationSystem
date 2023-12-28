package com.notification.notification_services.customerMangment.customerBSL;
import com.notification.notification_services.customerMangment.customerModeles.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Authorization {
    private final List<Customer> accounts;

    public Authorization() {
        this.accounts = new ArrayList<>();
    }



    public String createAccount(Customer customer){

        for(Customer custmers:accounts){
            if (custmers.getUserName().equals(customer.getUserName())){
                //System.out.println("this user name already exist");
                return "this user name already exists";
            }
        }
        accounts.add(customer);
        return "added successfully";


    }
    public Customer login(String userName,String password){
        for(Customer custmer:accounts) {

            if (custmer.getUserName().equals(userName) ){
                if (custmer.getPassword().equals(password)) {
                    System.out.println("successful login ");
                    return custmer;
                }
                return null;
            }
        }
        return null;
    }
}

