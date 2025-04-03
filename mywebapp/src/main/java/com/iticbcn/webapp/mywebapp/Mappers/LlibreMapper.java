package com.iticbcn.webapp.mywebapp.Mappers;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.iticbcn.webapp.mywebapp.DTO.LlibreDTO;
import com.iticbcn.webapp.mywebapp.DomainModel.Llibre;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LlibreMapper {

    @Mapping(target="titol", source="llibre.titol")
    @Mapping(target="autor", source="llibre.autor")
    @Mapping(target="editorial", source="llibre.editorial")
    @Mapping(target = "datapublicacio", source = "llibre.datapublicacio")
    @Mapping(target = "tematica", source = "llibre.tematica")
    @Mapping(target = "isbn", source = "llibre.isbn")
    LlibreDTO LlibreToLlibreDTO(Llibre llibre);

    @Mapping(target="titol", source="llibreDTO.titol")
    @Mapping(target="autor", source="llibreDTO.autor")
    @Mapping(target="editorial", source="llibreDTO.editorial")
    @Mapping(target = "datapublicacio", source = "llibreDTO.datapublicacio")
    @Mapping(target = "tematica", source = "llibreDTO.tematica")
    @Mapping(target = "isbn", source = "llibreDTO.isbn")
    Llibre LlibreDTOToLlibre(LlibreDTO llibreDTO);

    Set<Llibre> LlibresDTOToLlibres(Set<LlibreDTO> llibresDTO);
    Set<LlibreDTO> LlibresToLlibresDTO(Set<Llibre> llibres);     
}
