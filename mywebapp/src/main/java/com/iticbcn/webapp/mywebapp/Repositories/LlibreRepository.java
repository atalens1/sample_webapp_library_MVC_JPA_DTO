package com.iticbcn.webapp.mywebapp.Repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.Set;
import com.iticbcn.webapp.mywebapp.DomainModel.Llibre;

@Repository
public interface LlibreRepository extends CrudRepository<Llibre, Long> {

    @Override
    @NonNull
    Set<Llibre> findAll();
    
    Llibre findByTitol(String titol);
    Llibre findByTitolAndEditorial(String titol, String Editorial);
}

