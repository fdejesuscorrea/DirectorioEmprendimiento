package com.udea.edu.co.directorio.controllers;

import com.udea.edu.co.directorio.entities.Novedad;
import com.udea.edu.co.directorio.entities.Usuario;
import com.udea.edu.co.directorio.request.CreateNovedadRequest;
import com.udea.edu.co.directorio.services.NovedadService;;
import com.udea.edu.co.directorio.services.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/novedades")
public class AdminNovedadController {
    @Autowired
    private NovedadService novedadService;
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<Novedad> createNovedad(
            @RequestHeader("Authorization") String jwt,
            @RequestBody CreateNovedadRequest req
    )throws Exception{
        Usuario usuario = usuarioService.findUsuarioByJwtToken(jwt);
        Novedad novedad = novedadService.createNovedad(req);
        return new ResponseEntity<>(novedad, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Novedad> updateNovedad(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id,
            @RequestBody CreateNovedadRequest req
    )throws Exception{
        Usuario usuario = usuarioService.findUsuarioByJwtToken(jwt);
        Novedad novedad = novedadService.updateNovedad(id,req);
        return new ResponseEntity<>(novedad,HttpStatus.ACCEPTED);
    }
}
