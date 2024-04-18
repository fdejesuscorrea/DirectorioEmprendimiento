package com.udea.edu.co.directorio.controllers;

import com.udea.edu.co.directorio.entities.Usuario;
import com.udea.edu.co.directorio.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/perfil")
    public ResponseEntity<Usuario> findUsuarioByJwtToken(@RequestHeader("Authorization")String jwt) throws Exception
    {
        Usuario usuario = usuarioService.findUsuarioByJwtToken(jwt);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
