package com.example.militaryfreelancer.util;

import com.example.militaryfreelancer.Models.Customer.Customer;
import com.example.militaryfreelancer.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {
    private final CustomerService customerService;
    @Autowired
    public CustomerValidator(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        for (Customer c:customerService.findAll()) {
            if(c.getEmail().equals(customer.getEmail())){
                errors.rejectValue("email","","Ця пошта вже використовується");

            }
            if(c.getPhone().equals(customer.getPhone())){
                errors.rejectValue("phone","","Цей телефон вже використовується");
            }
        }
    }
}
