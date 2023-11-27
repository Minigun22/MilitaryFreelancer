package com.example.militaryfreelancer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @Value("${hello_value}")
    private String helloString;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
