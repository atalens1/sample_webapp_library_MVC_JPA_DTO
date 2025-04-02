package com.iticbcn.webapp.mywebapp.Controllers;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.iticbcn.webapp.mywebapp.DTO.LlibreDTO;
import com.iticbcn.webapp.mywebapp.DomainModel.Usuaris;
import com.iticbcn.webapp.mywebapp.Services.LlibreService;

@Controller
@SessionAttributes("users")
public class BookController {

    @Autowired
    private LlibreService llibreService; 

    @GetMapping("/")
    public String iniciar(Model model) {
        return "login";
    }

    @PostMapping("/index")
    public String login(@ModelAttribute("users") Usuaris users, Model model) {

        model.addAttribute("users", users);

        if (users.getUsuari().equals("toni") 
        && users.getPassword().equals("h3ll0!!")) {
            return "index";
        } else {
            return "login";
        }        
    }

    @GetMapping("/index")
    public String index(@ModelAttribute("users") Usuaris users, Model model) {

            return "index";
        
    }

    @GetMapping("/consulta") 
    public String consulta(@ModelAttribute("users") Usuaris users,Model model) {

        // ArrayList<Llibre> llibres = repoll.getAllLlibres();
        //Set<Llibre> llibres = llibreService.findAll();
        Set<LlibreDTO> llibreDTOs = llibreService.findAll();

        model.addAttribute("llibreDTOs", llibreDTOs);
        
        return "consulta";
    }

    @GetMapping("/inserir") 
    public String inputInserir(@ModelAttribute("users") Usuaris users,Model model) {

        model.addAttribute("llibreErr", true);
        model.addAttribute("message", "");
        return "inserir";
    }

    @GetMapping("/cercaid")
    public String inputCerca(@ModelAttribute("users") Usuaris users, Model model) {

        //Llibre llibre = new Llibre();
        // llibre.setIdLlibre(0);
        LlibreDTO llibreDTO = new LlibreDTO();
        model.addAttribute("llibreErr", true);
        model.addAttribute("message", "");
        //model.addAttribute("llibre", llibre);
        model.addAttribute("llibreDTO", llibreDTO);

        return "cercaid";

    }


    // @PostMapping("/inserir")
    // public String inserir(@ModelAttribute("users") Usuaris users, 
    //                       @RequestParam(name = "titol") String titol,  
    //                       @RequestParam(name = "autor") String autor,  
    //                       @RequestParam(name = "editorial") String editorial,  
    //                       @RequestParam(name = "datapublicacio") String datapublicacio,
    //                       @RequestParam(name = "tematica") String tematica,  
    //                       Model model) {

    @PostMapping("/inserir")
    public String inserir(@ModelAttribute("users") Usuaris users, 
                          @ModelAttribute LlibreDTO llibreDTO,
                          Model model) {


        // String message = "";
        // boolean llibreErr = false;

        // if (idLlibre == null || !idLlibre.matches("\\d+")) {
        //     message = "La id de llibre ha de ser un nombre enter";
        //     llibreErr = true;
        //     model.addAttribute("message", message);
        //     model.addAttribute("llibreErr", llibreErr);
        //     return "inserir";
        // } else {
        //     //int idLl = Integer.parseInt(idLlibre);
        //     Long idLl = Long.parseLong(idLlibre);
        //     LocalDate dataPub = LocalDate.parse(datapublicacio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //     Llibre llibre = new Llibre(idLl,titol,autor,editorial,dataPub,tematica);
        //     // repoll.InsertaLlibre(llibre);
        //     // ArrayList<Llibre> llibres = repoll.getAllLlibres();
        //     llibreService.save(llibre);
        //     Set<Llibre> llibres = llibreService.findAll();
        //     model.addAttribute("llibres", llibres);
        //     return "consulta";            
        // }

        llibreService.save(llibreDTO);    

        // Llibre llibre = new Llibre();
        // llibre.setTitol(titol);
        // llibre.setAutor(autor);
        // LocalDate dataPub = LocalDate.parse(datapublicacio, DateTimeFormatter.ofPattern("d/M/yyyy"));
        // llibre.setDatapublicacio(dataPub);
        // llibre.setEditorial(editorial);
        // llibre.setTematica(tematica);

        // llibreService.save(llibre);

        // Set<Llibre> llibres = llibreService.findAll();
        // model.addAttribute("llibres", llibres);

        Set<LlibreDTO> llibreDTOs = llibreService.findAll();

        model.addAttribute("llibreDTOs", llibreDTOs);
        return "consulta";  

        // try {
        //     llibre.setIdLlibre(Integer.parseInt(idLlibre));
        //     repoll.InsertaLlibre(llibre);
        //     ArrayList<Llibre> llibres = repoll.getAllLlibres();
        //     model.addAttribute("llibres", llibres);
        //     return "consulta";
        // } catch (Exception e) {
        //     message = "La id de llibre ha de ser un nombre enter";
        //     llibreErr = true;
        //     model.addAttribute("message", message);
        //     model.addAttribute("llibreErr",llibreErr);
        //     return "inserir";
        // }
    }

    @PostMapping("/cercaid")
    public String cercaId(@ModelAttribute("users") Usuaris users,
                          @RequestParam(name = "idLlibre", required = false) String idLlibre, 
                          Model model) {
        
        String message = "";
        boolean llibreErr = false;

        try {
            Long idLl = Long.parseLong(idLlibre);
            // Llibre llibre = repoll.getLlibreID(Integer.parseInt(idLlibre));
            //Optional<Llibre> llibre = llibreService.findByIdLlibre(idLl);

            Optional<LlibreDTO> llibreDTO = llibreService.findByIdLlibre(idLl);

            if (llibreDTO.isPresent()) {
                model.addAttribute("llibreDTO", llibreDTO);
            } else {
                message = "No hi ha cap llibre amb aquesta id";
                llibreErr = true;
            }
            // if(llibre !=null) {
            //     model.addAttribute("llibre", llibre);
            // } else {
            //     message = "No hi ha cap llibre amb aquesta id";
            //     llibreErr = true;
            // }

        } catch (Exception e) {
            message = "La id de llibre ha de ser un nombre enter";
            llibreErr = true;
        } 
        
        model.addAttribute("message", message);
        model.addAttribute("llibreErr",llibreErr);

        return "cercaid";

    }

    @PostMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }


    @ModelAttribute("users")
    public Usuaris getDefaultUser() {
        return new Usuaris(); 
    }
    
}
