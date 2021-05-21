package com.example.it351_assignment_5;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String address;
    private String company;
    private String phoneNumber;

    public Contact(String name, String address, String company, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.company = company;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCompany(){
        return company;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name + " - " +  company;
    }
}
