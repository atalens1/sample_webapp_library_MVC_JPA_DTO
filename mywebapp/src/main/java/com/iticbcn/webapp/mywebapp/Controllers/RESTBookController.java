package com.iticbcn.webapp.mywebapp.Controllers;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iticbcn.webapp.mywebapp.DTO.LlibreDTO;
import com.iticbcn.webapp.mywebapp.Services.LlibreService;

@RestController
@RequestMapping("/api/llibreria")
public class RESTBookController {

    @Autowired
    private LlibreService llibreService; 

    @GetMapping("/")
    public String iniciar() {
        return "API BIBLIOTECA";
    }

    @GetMapping("/consulta") 
    public Set<LlibreDTO> consulta() {

        Set<LlibreDTO> llibreDTOs = llibreService.findAll();
        
        return llibreDTOs;
    }

    @PostMapping("/inserir")
    public String inserir(@RequestBody LlibreDTO llibreDTO) {

        llibreService.save(llibreDTO);    

        return "llibre inserit amb èxit";  
    }

    @GetMapping("/cercaid")
    public ResponseEntity<?> cercaId(@RequestParam String idLlibre) {
        
        try {
            Long idLl = Long.parseLong(idLlibre);

            Optional<LlibreDTO> llibreDTO = llibreService.findByIdLlibre(idLl);

                 return llibreDTO
                        .map(llibre -> ResponseEntity.ok(llibre.toString()))
                        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No hi ha cap llibre amb aquesta id"));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ID no vàlid: ha de ser un número.");
        } 

    }
    
}
