package com.example.militaryfreelancer.Controller;

import com.example.militaryfreelancer.DAO.CustomerDAO;
import com.example.militaryfreelancer.Models.Customer.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerDAO customerDAO;
    @Autowired
    public CustomerController(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }
    @GetMapping()
    public String getCustomers(Model model){
        model.addAttribute("customers", customerDAO.getCustomerList());
        return "Customer/customers";
    }
    @GetMapping("/registration")
    public String getCreateCustomerForm(@ModelAttribute("customer") Customer customer){
        return "Customer/registration";
    }
    @PostMapping()
    public String registerCustomer(@ModelAttribute("customer") @Valid Customer customer,
                                   BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "Customer/registration";
        }
        customerDAO.registerCustomer(customer);
        return "redirect:/customer";
    }
}
