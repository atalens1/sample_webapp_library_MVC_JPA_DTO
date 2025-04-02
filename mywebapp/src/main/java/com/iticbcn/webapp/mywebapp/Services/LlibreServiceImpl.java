package com.iticbcn.webapp.mywebapp.Services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iticbcn.webapp.mywebapp.DTO.LlibreDTO;
import com.iticbcn.webapp.mywebapp.DomainModel.Llibre;
import com.iticbcn.webapp.mywebapp.Repositories.LlibreRepository;
import com.iticbcn.webapp.mywebapp.Mappers.LlibreMapper;


@Service
public class LlibreServiceImpl implements LlibreService{

    
    private final LlibreRepository llibreRepository;

    private final LlibreMapper llibreMapper;

    @Autowired
    public LlibreServiceImpl(LlibreRepository llibreRepository, LlibreMapper llibreMapper){
        this.llibreRepository = llibreRepository;
        this.llibreMapper = llibreMapper;
    }

    @Override
    public Set<LlibreDTO> findAll() {
        Set<Llibre> llibres = llibreRepository.findAll();
        return llibreMapper.LlibresToLlibresDTO(llibres);
//        return llibreRepository.findAll();
    }

    @Override
    public LlibreDTO findByTitol(String titol) {
        //return llibreRepository.findByTitol(titol);
        Llibre llibre = llibreRepository.findByTitol(titol);
        return llibreMapper.LlibreToLlibreDTO(llibre);
    }

    @Override
    public LlibreDTO findByTitolAndEditorial(String titol, String Editorial) {
        //return llibreRepository.findByTitolAndEditorial(titol, Editorial);
        Llibre llibre = llibreRepository.findByTitolAndEditorial(titol,Editorial);
        return llibreMapper.LlibreToLlibreDTO(llibre);
    }

    @Override
    public void save(LlibreDTO llibreDTO) {
        Llibre llibre = llibreMapper.LlibreDTOToLlibre(llibreDTO);
        llibreRepository.save(llibre);
    }

    public Optional<LlibreDTO> convertirLlibre(Optional<Llibre> llibre) {
        return llibre.map(llibreMapper::LlibreToLlibreDTO);
    }

    @Override
    public Optional<LlibreDTO> findByIdLlibre(Long idLlibre) {
        Optional<Llibre> llibre = llibreRepository.findById(idLlibre);
        return convertirLlibre(llibre);
        
    }

}
