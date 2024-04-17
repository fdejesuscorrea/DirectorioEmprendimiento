package com.udea.edu.co.directorio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nombre;

    private String email;

    private String resumen;


    private Boolean ifFormalized;



    private String whatsapp;

    private String webpage;

    private String logoName;


    private String superTipo;

    @Column(name="estado_emprendimiento")
    private String estadoEmprendimiento;
    // Getters and setters
}
