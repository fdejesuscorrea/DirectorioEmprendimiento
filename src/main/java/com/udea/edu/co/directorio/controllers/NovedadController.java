package com.udea.edu.co.directorio.controllers;


import com.udea.edu.co.directorio.entities.Novedad;
import com.udea.edu.co.directorio.repositories.NovedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/novedades")
public class NovedadController {
    @Autowired
    private NovedadRepository novedadRepository;
    @GetMapping
    public ResponseEntity<List<Novedad>> getAllNoticias() {
        List<Novedad> noticias=novedadRepository.findAll();
        return new ResponseEntity<>(noticias, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Novedad>> getNoticiasById(@PathVariable("id") Long id) {
        List<Novedad> noticia=new ArrayList<>();
        noticia.add(novedadRepository.findNovedadById(id));
        return new ResponseEntity<>(noticia, HttpStatus.OK);
    }
}
