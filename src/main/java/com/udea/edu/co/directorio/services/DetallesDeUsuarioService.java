package com.udea.edu.co.directorio.services;

import com.udea.edu.co.directorio.entities.ROL_USUARIO;
import com.udea.edu.co.directorio.entities.Usuario;
import com.udea.edu.co.directorio.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetallesDeUsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);
        if (usuario==null){
            throw new UsernameNotFoundException("El usuario no fue encontrado con el correo: "+username);
        }
        ROL_USUARIO rol = usuario.getRol();
        if(rol==null)rol=ROL_USUARIO.ROL_VISITANTE;
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(rol.toString()));
        return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getPassword(), authorities);
    }
}
