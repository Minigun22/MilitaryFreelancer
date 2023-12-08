//package com.example.militaryfreelancer.Controller;
//
//import com.example.militaryfreelancer.DAO.TemporaryVacancyDAO;
//import com.example.militaryfreelancer.Models.vacany.Vacancy;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/vacancy")
//public class VacancyController {
//
//    private final TemporaryVacancyDAO temporaryVacancyDAO;
//    @Autowired
//    public VacancyController(TemporaryVacancyDAO temporaryVacancyDAO) {
//        this.temporaryVacancyDAO = temporaryVacancyDAO;
//    }
//
//
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model){
//        model.addAttribute("vacancy", temporaryVacancyDAO.show(id));
//        return "/vacancy/show";
//    }
//
//
//
//
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id){
//        temporaryVacancyDAO.delete(id);
//        return "redirect:/vacancy/vacancies";
//    }
//}
