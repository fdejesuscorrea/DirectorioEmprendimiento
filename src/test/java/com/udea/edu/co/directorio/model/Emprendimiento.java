package com.udea.edu.co.directorio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Emprendimiento {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;


}
