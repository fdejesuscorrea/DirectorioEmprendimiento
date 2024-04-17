package com.udea.edu.co.directorio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprendedor {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    @ManyToOne
    private TipoDocumento tipoDocumento;

    private Long numeroDocumento;

    private String nombres;

    private String apellidos;

    private Long telefono;

    @ManyToOne
    private Vinculo vinculo;

    @ManyToOne
    private  Programa programa;

    @ManyToOne
    private Dependencia dependencia;

    @ManyToOne
    private Estado estado;

    @ManyToOne
    private Genero genero;

    private String linkedin;

    @ManyToMany
    private List<Emprendimiento> emprendimiento = new ArrayList<>();

}
