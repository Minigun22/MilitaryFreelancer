package com.example.militaryfreelancer.Controller;

import com.example.militaryfreelancer.DAO.TemporaryVacancyDAO;
import com.example.militaryfreelancer.Models.vacany.Vacancy;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacancy")
public class VacancyController {

    private final TemporaryVacancyDAO temporaryVacancyDAO;
    @Autowired
    public VacancyController(TemporaryVacancyDAO temporaryVacancyDAO) {
        this.temporaryVacancyDAO = temporaryVacancyDAO;
    }

    @GetMapping("/vacancies")
    public String index(Model model){
        model.addAttribute("vacancies", temporaryVacancyDAO.getVacancyList());
        return "/vacancy/vacancies";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("vacancy", temporaryVacancyDAO.show(id));
        return "/vacancy/show";
    }

    @GetMapping("/new")
    public String newVacancy(Model model){
        model.addAttribute("vacancies", new Vacancy());
        return "/vacancy/new";
    }

    @PostMapping()
    public String create(@ModelAttribute @Valid Vacancy vacancy,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/vacancy/new";
        }
        temporaryVacancyDAO.save(vacancy);
        return "redirect:vacancy/vacancies";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("vacancy", temporaryVacancyDAO.show(id));
        return "/vacancy/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("vacancy") Vacancy vacancy, @PathVariable("id") int id){
        temporaryVacancyDAO.update(id, vacancy);
        return  "redirect:vacancy/vacancies";
    }


}
