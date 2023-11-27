package com.example.militaryfreelancer.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private String name;
    private String surname;
    private String gmail;
    private int phone;
    private int id;

    public Customer(){

    }

    public Customer(int id, String name, String surname, String gmail, int phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gmail = gmail;
        this.phone = phone;
    }
}
