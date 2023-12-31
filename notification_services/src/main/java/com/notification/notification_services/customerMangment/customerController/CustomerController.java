package com.notification.notification_services.customerMangment.customerController;

import com.notification.notification_services.customerMangment.customerBSL.Authorization;
import com.notification.notification_services.customerMangment.customerModeles.Customer;
import com.notification.notification_services.inMemoeryCustomer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private Authorization authorization;
    public CustomerController(Authorization authorization) {
        this.authorization = authorization;}
    
    @PostMapping(value = "/addCustomer")
    public String createAccount(@RequestBody Customer customer){
        return authorization.createAccount(customer);
    }
    @GetMapping(value = "/loginCustomer/{userName}/{password}")
    public Customer login(@PathVariable("userName") String userName,@PathVariable("password") String password){
        return authorization.login(userName,password);
    }
    @GetMapping("/allCustomers")
    public List<Customer> getAllCustomer(){
        return inMemoeryCustomer.customers;
    }
}
