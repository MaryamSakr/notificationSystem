package com.notification.notification_services.notificationManagment.notificationController;

import com.notification.notification_services.notificationManagment.notificationBSL.TemplateBSL;
import com.notification.notification_services.notificationManagment.notificationModules.ChannelMod;

public abstract class ChanneController {
    protected ChannelMod channel;
    protected TemplateBSL temp;
    public abstract void send();
}
