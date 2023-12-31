package com.notification.notification_services.customerMangment.customerModeles;


import com.notification.notification_services.notificationManagment.notificationBSL.ChannelBSL;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String email="";
    private String userName;
    private String password;
    private String phone="";
    private double balance=1000;
    private Location location;
    private ChannelBSL channel ;
    
    public Customer(){}

    public Customer(String email, String userName, String password, String phone,double balance , ChannelBSL ch) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.balance=balance;
        this.channel = ch.getChannelType();
    }

    public Customer(String email, String userName, String password, String phone , ChannelBSL ch) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.channel = ch.getChannelType();
    }

    public Customer(String email, String userName, String password ,ChannelBSL ch) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.channel = ch.getChannelType();

    }

    public Customer(String email, String userName, String password, String phone, double balance, Location location , ChannelBSL ch) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.balance=balance;
        this.location=location;
        this.channel = ch.getChannelType();
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }


    public ChannelBSL getChannel() {
        return channel.getChannelType();
    }

    public void setChannel(ChannelBSL channel) {
        this.channel = channel;
    }

    public double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

