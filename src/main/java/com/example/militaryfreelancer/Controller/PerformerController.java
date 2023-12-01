package com.example.militaryfreelancer.Controller;

import com.example.militaryfreelancer.DAO.PerformerDAO;
import com.example.militaryfreelancer.Models.Performer.Performer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/performer")
public class PerformerController {

    private final PerformerDAO performerDAO;

    @Autowired
    public PerformerController(PerformerDAO performerDAO) {
        this.performerDAO = performerDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("performer", performerDAO.getPerformerList());
        return "/performer/performers";
    }

    @GetMapping("/new")
    public String newPerformer(Model model){
        model.addAttribute("performer", new Performer());
        return "/performer/new";
    }

    @PostMapping()
    public String create(@ModelAttribute @Valid Performer performer,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "performer/new";
        }
        performerDAO.save(performer);
        return "redirect:/performer";
    }


}
