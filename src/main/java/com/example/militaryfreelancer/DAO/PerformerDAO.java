package com.example.militaryfreelancer.DAO;

import com.example.militaryfreelancer.Models.Customer.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PerformerDAO {
    private static int CUSTOMERS_COUNT;
    private final List<Customer> performerList;

    {
        performerList = new ArrayList<>();
    }

    public List<Customer> getPerformerList(){
        return performerList;
    }

    public Customer get(int id){
        return performerList
                .stream()
                .filter(customer -> customer.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void registerCustomer(Customer customer){
        customer.setId(++CUSTOMERS_COUNT);
        performerList.add(customer);
    }
}
