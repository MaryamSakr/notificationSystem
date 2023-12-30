package com.notification.notification_services.notificationManagment.notificationBSL;

public class SmsBSL extends ChannelBSL{
    @Override
    public String send(String note) {
        return note + " Message Send Successfully Throw SMS";
    }
}
