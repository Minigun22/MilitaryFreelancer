package com.example.militaryfreelancer.Models.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private int id;
    private String name;
    private String surname;
    private String gmail;
    private String phone;
    private List<Vacancy> vacancyList;

    public Customer(){

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gmail='" + gmail + '\'' +
                ", phone=" + phone +
                ", vacancyList=" + vacancyList +
                '}';
    }
}
