package com.example.militaryfreelancer.Controller;

import com.example.militaryfreelancer.DAO.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerDAO customerDAO;
    @Autowired
    public CustomerController(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    @GetMapping("/create")
    public String getCreateCustomerForm(){
        return "NewCustomer";
    }
}
