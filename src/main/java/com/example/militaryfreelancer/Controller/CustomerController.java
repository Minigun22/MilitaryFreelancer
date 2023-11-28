package com.example.militaryfreelancer.Controller;

import com.example.militaryfreelancer.DAO.CustomerDAO;
import com.example.militaryfreelancer.Models.Customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerDAO customerDAO;
    @Autowired
    public CustomerController(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }
    @GetMapping()
    public String getCustomers(Model model){
        model.addAttribute("customers", customerDAO.getCustomerList());
        return "customers";
    }

    @GetMapping("/create")
    public String getCreateCustomerForm(){
        return "new";
    }
    @PostMapping()
    public String registerCustomer(@ModelAttribute("customer") Customer customer){
        customerDAO.registerCustomer(customer);
        return "redirect:/customers";
    }

}
