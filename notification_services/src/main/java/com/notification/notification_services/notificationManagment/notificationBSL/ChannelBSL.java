package com.notification.notification_services.notificationManagment.notificationBSL;

import com.notification.notification_services.orderManagement.orderModules.Order;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;

public abstract class ChannelBSL {

    public abstract String send(String note , Order s);
    public abstract ChannelBSL getChannelType();

}
