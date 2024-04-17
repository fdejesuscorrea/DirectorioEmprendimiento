package com.udea.edu.co.directorio.controllers;

import com.udea.edu.co.directorio.entities.Emprendimiento;
import com.udea.edu.co.directorio.repositories.EmprendimientoRepository;
import com.udea.edu.co.directorio.services.EmprendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/emprendimientos")
public class EmprendimientoController {

    @Autowired
    private EmprendimientoService emprendimientoService;

    @GetMapping("/search")
    public  ResponseEntity<List<Emprendimiento>> searchEmprendimiento(
            @RequestParam String keyword
    )throws Exception{
        List<Emprendimiento> emprendimientos = emprendimientoService.searchEmprendimiento(keyword);
        return new ResponseEntity<>(emprendimientos, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Emprendimiento>> getAllEmprendimientos() throws Exception {
        List<Emprendimiento> emprendimientos = emprendimientoService.getAllEmprendimientos();
        System.out.println("Se hizo");
        return new ResponseEntity<>(emprendimientos, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public  ResponseEntity<Emprendimiento> findEmprendimientoById(
            @PathVariable Long id
    )throws Exception{
        Emprendimiento emprendimiento = emprendimientoService.findEmprendimientoById(id);
        return new ResponseEntity<>(emprendimiento, HttpStatus.OK);
    }

}
