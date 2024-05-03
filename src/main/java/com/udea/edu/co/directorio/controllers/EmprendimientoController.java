package com.udea.edu.co.directorio.controllers;

import com.udea.edu.co.directorio.entities.Emprendimiento;
import com.udea.edu.co.directorio.entities.Usuario;
import com.udea.edu.co.directorio.repositories.EmprendimientoRepository;
import com.udea.edu.co.directorio.services.EmprendimientoService;
import com.udea.edu.co.directorio.services.UsuarioService;
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

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/search")
    public  ResponseEntity<List<Emprendimiento>> searchEmprendimiento(
            @RequestHeader("Authorization") String jwt,
            @RequestParam String keyword
    )throws Exception{
        Usuario usuario = usuarioService.findUsuarioByJwtToken(jwt);
        List<Emprendimiento> emprendimientos = emprendimientoService.searchEmprendimiento(keyword);
        return new ResponseEntity<>(emprendimientos, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Emprendimiento>> getAllEmprendimientos() throws Exception {
        List<Emprendimiento> emprendimientos = emprendimientoService.getAllEmprendimientos();
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
