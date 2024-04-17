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
public class Emprendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nombre;

    private String resumen;

    private boolean formalizada;

    private String nombreLogo;

    private String descripcion;

    @ManyToMany
    private List<Sector> sectores = new ArrayList<>();

    @ManyToMany
    private List<Servicio> servicios = new ArrayList<>();

    @ManyToMany
    private List<Emprendedor> fundadores = new ArrayList<>();

    @Embedded
    private InformacionDeContacto informacionDeContacto;

    @ManyToOne
    private EtapaMaduracion etapa;
}
