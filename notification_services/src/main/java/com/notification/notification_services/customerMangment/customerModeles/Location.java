package com.notification.notification_services.customerMangment.customerModeles;

public class Location {
    private String area;
    private String street;
    private String city;

    public Location(String area, String street, String city) {
        this.area = area;
        this.street = street;
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

