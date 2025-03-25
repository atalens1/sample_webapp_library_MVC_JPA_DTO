package com.iticbcn.webapp.mywebapp.Services;

import java.util.Optional;
import java.util.Set;

import com.iticbcn.webapp.mywebapp.DomainModel.Llibre;

public interface LlibreService {

    Set<Llibre> findAll();
    Llibre findByTitol(String titol);
    Set<Llibre> findByTitolAndEditorial(String titol, String Editorial);
    void save(Llibre llibre);
    Optional<Llibre> findByIdLlibre(Long idLlibre);

}
