package com.example.militaryfreelancer.DAO;

import com.example.militaryfreelancer.Models.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDAO {
    private final List<Customer> customerList;

    {
        customerList = new ArrayList<>();
    }

    public List<Customer> getCustomerList(){
        return customerList;
    }

    public Customer get(int id){
        return customerList
                .stream()
                .filter(customer -> customer.getId() == id)
                .findAny()
                .orElse(null);
    }
}
