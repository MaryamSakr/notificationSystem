package com.notification.notification_services.customerMangment.customerModeles;


public class Customer {
    private String email;
    private String userName;
    private String password;
    private String phone;

    private double balance=100;
    private Location location=null;


    public Customer(String email, String userName, String password, String phone,double balance) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.balance=balance;
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


}

