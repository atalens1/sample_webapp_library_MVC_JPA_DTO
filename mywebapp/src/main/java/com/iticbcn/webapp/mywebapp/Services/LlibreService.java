package com.iticbcn.webapp.mywebapp.Services;

import java.util.Optional;
import java.util.Set;

import com.iticbcn.webapp.mywebapp.DTO.LlibreDTO;

public interface LlibreService {

    Set<LlibreDTO> findAll();
    LlibreDTO findByTitol(String titol);
    LlibreDTO findByTitolAndEditorial(String titol, String Editorial);
    void save(LlibreDTO llibreDTO);
    Optional<LlibreDTO> findByIdLlibre(Long idLlibre);
}
