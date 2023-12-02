package com.example.militaryfreelancer.Controller;

import com.example.militaryfreelancer.Models.vacany.Vacancy;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vacancy")
public class VacancyController {

    @GetMapping("/new")
    public String newVacancy(Model model){
        model.addAttribute("vacancy", new Vacancy());
        return "/vacancy/new";
    }

    @PostMapping()
    public String create(@ModelAttribute @Valid Vacancy vacancy,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/vacancy/new";
        }
        return "vacancy/vacancies";
    }


}
