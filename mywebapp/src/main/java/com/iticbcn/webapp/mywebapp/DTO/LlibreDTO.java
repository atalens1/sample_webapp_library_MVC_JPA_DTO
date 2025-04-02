package com.iticbcn.webapp.mywebapp.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LlibreDTO {
    private String titol;
    private String autor;
    private String editorial;
    private LocalDate datapublicacio;
    private String tematica;
    private String isbn;
}
