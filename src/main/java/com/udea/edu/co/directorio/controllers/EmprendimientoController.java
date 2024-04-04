package com.udea.edu.co.directorio.controllers;

import com.udea.edu.co.directorio.entities.Emprendimiento;
import com.udea.edu.co.directorio.repositories.EmprendimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emprendimientos")
public class EmprendimientoController {

    @Autowired
    private EmprendimientoRepository emprendimientoRepository;

    @GetMapping
    public ResponseEntity<List<Emprendimiento>> getAllEmprendimientos() {
        List<Emprendimiento> emprendimientos = (List<Emprendimiento>) emprendimientoRepository.findAll();
        return new ResponseEntity<>(emprendimientos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Emprendimiento>> getEmprendimiento(@PathVariable("id") int id) {
        List<Emprendimiento> emprendimiento=new ArrayList<>();
        emprendimiento.add(emprendimientoRepository.findEmprendimientoById(id));
        return new ResponseEntity<>(emprendimiento, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Emprendimiento> createEmprendimiento(@RequestBody Emprendimiento emprendimiento) {
        Emprendimiento savedEmprendimiento = emprendimientoRepository.save(emprendimiento);
        return new ResponseEntity<>(savedEmprendimiento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprendimiento> updateEmprendimiento(@PathVariable("id") int id, @RequestBody Emprendimiento emprendimiento) {
        Emprendimiento existingEmprendimiento = emprendimientoRepository.findById(id)
                .orElse(null);
        if (existingEmprendimiento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Emprendimiento updatedEmprendimiento = emprendimientoRepository.save(emprendimiento);
        return new ResponseEntity<>(updatedEmprendimiento, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmprendimiento(@PathVariable("id") int id) {
        emprendimientoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
