package com.udea.edu.co.directorio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprendedor {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private TipoDocumento tipoDocumento;

    private Long numeroDocumento;

    private String nombres;

    private String apellidos;

    private Long telefono;

    @OneToMany
    private Vinculo vinculo;

    @OneToMany
    private  Programa programa;

    @OneToMany
    private Dependencia dependencia;

    @OneToMany
    private Estado estado;

    @OneToMany
    private Genero genero;

    private String linkedin;

}
