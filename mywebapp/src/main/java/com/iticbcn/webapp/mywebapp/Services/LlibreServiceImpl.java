package com.iticbcn.webapp.mywebapp.Services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iticbcn.webapp.mywebapp.DomainModel.Llibre;
import com.iticbcn.webapp.mywebapp.Repositories.LlibreRepository;

@Service
public class LlibreServiceImpl implements LlibreService{

    @Autowired
    LlibreRepository llibreRepository;

    @Override
    public Set<Llibre> findAll() {
        return llibreRepository.findAll();
    }

    @Override
    public Llibre findByTitol(String titol) {
        return llibreRepository.findByTitol(titol);
    }

    @Override
    public Set<Llibre> findByTitolAndEditorial(String titol, String Editorial) {
        return llibreRepository.findByTitolAndEditorial(titol, Editorial);
    }

    @Override
    public void save(Llibre llibre) {
        llibreRepository.save(llibre);
    }

    @Override
    public Optional<Llibre> findByIdLlibre(Long idLlibre) {
        return llibreRepository.findById(idLlibre);
    }

}
