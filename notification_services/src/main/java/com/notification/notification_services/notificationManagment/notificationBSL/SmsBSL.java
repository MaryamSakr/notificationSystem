package com.notification.notification_services.notificationManagment.notificationBSL;

import com.notification.notification_services.customerMangment.customerModeles.Customer;
import com.notification.notification_services.inMemoeryCustomer;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SmsBSL extends ChannelBSL{
    private String sms;
    public static Map<Object, Integer> SmsCountMap = new HashMap<>();

    private static void updateElementCount(String ele) {
        if (ele.equals("")) {
            int count = SmsCountMap.getOrDefault(ele, 0);
            SmsCountMap.put(ele, count + 1);
        }
    }
    @Override
    public String send(String note , SimpleOrder s) {
        String p = "";
        for (Customer customer : inMemoeryCustomer.customers) {
            if(s.getCustomerName().equals(customer.getUserName())){
                p = customer.getPhone();
            }
        }
        updateElementCount(p);
        return note + " Message Send Successfully Throw SMS";
    }


}
