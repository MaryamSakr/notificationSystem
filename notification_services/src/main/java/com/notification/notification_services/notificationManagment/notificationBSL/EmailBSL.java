package com.notification.notification_services.notificationManagment.notificationBSL;

import com.notification.notification_services.customerMangment.customerModeles.Customer;
import com.notification.notification_services.inMemoeryCustomer;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class EmailBSL extends ChannelBSL{
    private String email;
    public static Map<Object, Integer> EmailsCountMap = new HashMap<>();

    private static void updateElementCount(String ele) {
        if (ele.equals("")) {
            int count = EmailsCountMap.getOrDefault(ele, 0);
            EmailsCountMap.put(ele, count + 1);
        }
    }
    @Override
    public String send(String note , SimpleOrder s) {
        String e = "";
        for (Customer customer : inMemoeryCustomer.customers) {
            if(s.getCustomerName().equals(customer.getUserName())){
                e = customer.getEmail();
            }
        }
        updateElementCount(e);
        return note + " Message Send Successfully Throw Email";
    }

}