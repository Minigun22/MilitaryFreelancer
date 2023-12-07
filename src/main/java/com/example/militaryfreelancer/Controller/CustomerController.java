package com.example.militaryfreelancer.Controller;


import com.example.militaryfreelancer.Models.Customer.Customer;
import com.example.militaryfreelancer.Service.CustomerService;
import com.example.militaryfreelancer.util.CustomerValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerValidator customerValidator;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerValidator customerValidator) {
        this.customerService = customerService;
        this.customerValidator = customerValidator;
    }

    @GetMapping()
    public String getCustomers(Model model){
        model.addAttribute("customers", customerService.findAll());
        return "Customer/customers";
    }
    @GetMapping("/new")
    public String getCreateCustomerForm(@ModelAttribute("customer") Customer customer){
        return "Customer/new";
    }
    @PostMapping()
    public String registerCustomer(@ModelAttribute("customer") @Valid Customer customer,
                                   BindingResult bindingResult){
        customerValidator.validate(customer, bindingResult);

        if(bindingResult.hasErrors()){
            return "Customer/new";
        }
        customerService.save(customer);
        return "redirect:/customers";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id,Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "Customer/show";
    }
}
