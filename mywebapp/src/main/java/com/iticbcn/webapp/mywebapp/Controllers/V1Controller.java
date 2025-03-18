package com.iticbcn.webapp.mywebapp.Controllers;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import com.iticbcn.webapp.mywebapp.Model.Llibre;
import com.iticbcn.webapp.mywebapp.Model.Usuaris;
import com.iticbcn.webapp.mywebapp.Repositories.RepoLlibre;

@Controller
public class V1Controller {

    @Autowired
    RepoLlibre repoll = new RepoLlibre();

    @GetMapping("/")
    public String iniciar(Model model) {
        return "login";
    }

    @PostMapping("/")
    public String login(Usuaris users, Model model) {

        if (users.getUsuari().equals("toni") 
        && users.getPassword().equals("h3ll0!!")) {
            ArrayList<Llibre> llibres = repoll.getAllLlibres();
            model.addAttribute("users", users);
            model.addAttribute("llibres", llibres);
            return "consulta";
        } else {
            return "login";
        }
        
    }
    
}
