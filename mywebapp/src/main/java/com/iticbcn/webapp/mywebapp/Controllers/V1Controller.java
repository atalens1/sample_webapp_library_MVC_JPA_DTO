package com.iticbcn.webapp.mywebapp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class V1Controller {

    @GetMapping("/")
    public String iniciar() {
        return "index";
    }

    @PostMapping("/")
    public String login() {
        return "consulta";
    }


    
}
