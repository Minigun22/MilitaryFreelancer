package com.example.militaryfreelancer.Controller;


import com.example.militaryfreelancer.Models.Customer.Customer;
import com.example.militaryfreelancer.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping()
    public String getCustomers(Model model){
        model.addAttribute("customers", customerService.findAll());
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
        customerService.save(customer);
        return "redirect:/customer";
    }
}
