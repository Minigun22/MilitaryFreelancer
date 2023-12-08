package com.example.militaryfreelancer.Controller;


import com.example.militaryfreelancer.Models.Customer.Customer;
import com.example.militaryfreelancer.Models.vacany.Vacancy;
import com.example.militaryfreelancer.Service.CustomerService;
import com.example.militaryfreelancer.Service.VacancyService;
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
    private final VacancyService vacancyService;
    private final CustomerValidator customerValidator;

    @Autowired
    public CustomerController(CustomerService customerService, VacancyService vacancyService, CustomerValidator customerValidator) {
        this.customerService = customerService;
        this.vacancyService = vacancyService;
        this.customerValidator = customerValidator;
    }

    @GetMapping()
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "Customer/customers";
    }

    @GetMapping("/new")
    public String getCreateCustomerForm(@ModelAttribute("customer") Customer customer) {
        return "Customer/new";
    }

    @PostMapping()
    public String registerCustomer(@ModelAttribute("customer") @Valid Customer customer,
                                   BindingResult bindingResult) {
        customerValidator.validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            return "Customer/new";
        }
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "Customer/show";
    }

    @GetMapping("/{id}/vacancies/new")
    public String newVacancy(@PathVariable("id") long id, Model model) {
        model.addAttribute("vacancy", new Vacancy());
        model.addAttribute("id", id);
        return "Customer/vacancy/new";
    }

    @PostMapping("/{id}/vacancies/new")
    public String create(@PathVariable("id") long id, @ModelAttribute @Valid Vacancy vacancy,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Customer/vacancy/new";
        }
        vacancy.setCustomer(customerService.findById(id));
        vacancyService.save(vacancy);
        return "redirect:/customers/{id}";
    }

    @GetMapping("/{customer_id}/vacancies/{vacancy_id}")
    public String showVacancy(@PathVariable("customer_id") long customer_id,
                              @PathVariable("vacancy_id") long vacancy_id, Model model) {
        model.addAttribute("vacancy", vacancyService.findById(vacancy_id));
        return "Customer/vacancy/show";
    }

    @GetMapping("/{customer_id}/vacancies/{vacancy_id}/edit")
    public String edit(Model model, @PathVariable("vacancy_id") long vacancy_id, @PathVariable("customer_id") long customer_id) {
        model.addAttribute("vacancy", vacancyService.findById(vacancy_id));
        model.addAttribute("customer_id", customer_id);
        return "Customer/vacancy/edit";
    }

    @PatchMapping("/{customer_id}/vacancies/{vacancy_id}/edit")
    public String update(@ModelAttribute("vacancy") @Valid Vacancy vacancy, BindingResult bindingResult,
                         @PathVariable("customer_id") long customer_id, @PathVariable("vacancy_id") long vacancy_id) {
        if (bindingResult.hasErrors()) {
            return "Customer/vacancy/edit";
        }
        vacancy.setCustomer(customerService.findById(customer_id));
        vacancyService.update(vacancy_id, vacancy);
        return "redirect:/customers/{customer_id}";
    }

    @DeleteMapping("/{customer_id}/vacancies/{vacancy_id}")
    public String delete(@PathVariable("customer_id") long customer_id, @PathVariable("vacancy_id") long vacancy_id) {
        vacancyService.delete(vacancy_id);
        return "redirect:/customers/{customer_id}";
    }
}
