package com.example.militaryfreelancer.Customer;

public class Customer {
    private String name;
    private String surname;
    private String gmail;
    private int phone;

    public Customer(){

    }

    public Customer(String name, String surname, String gmail, int phone) {
        this.name = name;
        this.surname = surname;
        this.gmail = gmail;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGmail() {
        return gmail;
    }

    public int getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
