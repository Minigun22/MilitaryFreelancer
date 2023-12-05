package com.example.militaryfreelancer.Models.Customer;

import com.example.militaryfreelancer.Models.Customer.Rank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Vacancy {
    private String vacancyName;
    private String unitName;
    private String personName;
    private Rank rank;
    private String email;
    private String phone;


    public Vacancy(){}
}
