package com.udea.edu.co.directorio.controllers;

import com.udea.edu.co.directorio.entities.Emprendedor;
import com.udea.edu.co.directorio.repositories.EmprendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprendedores")
public class EmprendedorController {
    @Autowired
    private EmprendedorRepository emprendedorRepository;

    @GetMapping
    public ResponseEntity<List<Emprendedor>> getAllEmprendedores() {
        List<Emprendedor> emprendedores = (List<Emprendedor>) emprendedorRepository.findAll();
        return new ResponseEntity<>(emprendedores, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Emprendedor> createEmprendedor(@RequestBody Emprendedor emprendedor) {
        Emprendedor savedEmprendedor = emprendedorRepository.save(emprendedor);
        return new ResponseEntity<>(savedEmprendedor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprendedor> updateEmprendedor(@PathVariable("id") int id, @RequestBody Emprendedor emprendedor) {
        Emprendedor existingEmprendedor = emprendedorRepository.findById(id)
                .orElse(null);
        if (existingEmprendedor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        emprendedor.setIdNumber(id);
        Emprendedor updatedEmprendedor = emprendedorRepository.save(emprendedor);
        return new ResponseEntity<>(updatedEmprendedor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmprendedor(@PathVariable("id") int id) {
        emprendedorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
