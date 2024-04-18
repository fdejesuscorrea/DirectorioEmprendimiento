package com.udea.edu.co.directorio.services;

import com.udea.edu.co.directorio.config.JwtProvider;
import com.udea.edu.co.directorio.entities.Usuario;
import com.udea.edu.co.directorio.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImplementation implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public Usuario findUsuarioByJwtToken(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromJwtToken(jwt);
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario;
    }

    @Override
    public Usuario findUsuarioByEmail(String email) throws Exception {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario==null){
            throw new Exception("Usuario no encontrado");
        }
        return usuario;
    }
}
