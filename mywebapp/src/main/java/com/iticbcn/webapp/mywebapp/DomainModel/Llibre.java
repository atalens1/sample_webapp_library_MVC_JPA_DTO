package com.iticbcn.webapp.mywebapp.DomainModel;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Llibre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_llibre;
    @Column(unique = true, nullable = false)
    private String titol;
    @Column(nullable = false)
    private String autor;
    @Column(nullable = false)
    private String editorial;
    @Column(nullable = false)
    private LocalDate datapublicacio;
    @Column(nullable = false)
    private String tematica;
    @Column(unique = true, nullable = false)
    private String isbn;
}
