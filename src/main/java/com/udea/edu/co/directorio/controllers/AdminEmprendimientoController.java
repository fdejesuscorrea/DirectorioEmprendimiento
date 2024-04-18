package com.udea.edu.co.directorio.controllers;

import com.udea.edu.co.directorio.entities.Emprendimiento;
import com.udea.edu.co.directorio.entities.Usuario;
import com.udea.edu.co.directorio.repositories.EmprendedorRepository;
import com.udea.edu.co.directorio.request.CreateEmprendimientoRequest;
import com.udea.edu.co.directorio.response.MessageResponse;
import com.udea.edu.co.directorio.services.EmprendedorService;
import com.udea.edu.co.directorio.services.EmprendimientoService;
import com.udea.edu.co.directorio.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/emprendimientos")
public class AdminEmprendimientoController {

    @Autowired
    private EmprendimientoService emprendimientoService;

    @Autowired
    private EmprendedorService emprendedorService;

    @Autowired
    private EmprendedorRepository emprendedorRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<Emprendimiento> createEmprendimiento(
            @RequestHeader("Authorization") String jwt,
            @RequestBody CreateEmprendimientoRequest req
            )throws Exception{
        Usuario usuario = usuarioService.findUsuarioByJwtToken(jwt);
        Emprendimiento emprendimiento = emprendimientoService.createEmeprendimiento(req);
        return new ResponseEntity<>(emprendimiento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprendimiento> updateEmprendimiento(
            @RequestHeader("Authorization") String jwt,
            @RequestBody CreateEmprendimientoRequest req,
            @PathVariable Long id
    ) throws Exception{
        Usuario usuario = usuarioService.findUsuarioByJwtToken(jwt);
        Emprendimiento emprendimiento = emprendimientoService.updateEmprendimiento(id, req);
        return new ResponseEntity<>(emprendimiento, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteEmprendimiento(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    )throws Exception{
        Usuario usuario = usuarioService.findUsuarioByJwtToken(jwt);
        emprendimientoService.deleteEmprendimiento(id);
        MessageResponse res = new MessageResponse();
        res.setMessage("El emprendimiento ha sido eliminado correctamente");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/{id}/formalizada")
    public ResponseEntity<Emprendimiento> updateEmprendimientoFormalizacion(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    )throws Exception{
        Usuario usuario = usuarioService.findUsuarioByJwtToken(jwt);
        Emprendimiento emprendimiento = emprendimientoService.updateEmprendimientoFormalizacion(id);
        return new ResponseEntity<>(emprendimiento, HttpStatus.OK);
    }

}
