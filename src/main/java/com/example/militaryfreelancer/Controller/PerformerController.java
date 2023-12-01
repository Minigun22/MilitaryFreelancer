package com.example.militaryfreelancer.Controller;

import com.example.militaryfreelancer.Models.Performer.Performer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/performer")
public class PerformerController {

    @GetMapping("/new")
    public String newPerformer(@ModelAttribute("performer") Performer performer){
        return "/performer/new";
    }


}
