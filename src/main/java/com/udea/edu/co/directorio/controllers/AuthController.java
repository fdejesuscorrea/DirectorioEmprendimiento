package com.udea.edu.co.directorio.controllers;

import com.udea.edu.co.directorio.config.JwtProvider;
import com.udea.edu.co.directorio.entities.ROL_USUARIO;
import com.udea.edu.co.directorio.entities.Usuario;
import com.udea.edu.co.directorio.repositories.UsuarioRepository;
import com.udea.edu.co.directorio.request.LoginRequest;
import com.udea.edu.co.directorio.response.AuthResponse;
import com.udea.edu.co.directorio.services.DetallesDeUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    DetallesDeUsuarioService detallesDeUsuarioService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse>createUserHandler(@RequestBody Usuario usuario) throws Exception {
        Usuario isEmailExist = usuarioRepository.findByEmail(usuario.getEmail());
        if(isEmailExist!=null){
            throw new Exception("El ya se encuentra en uso con otra cuenta");
        }

        Usuario usuarioCreado = new Usuario();
        usuarioCreado.setEmail(usuario.getEmail());
        usuarioCreado.setFullName(usuario.getFullName());
        usuarioCreado.setRol(usuario.getRol());

        usuarioCreado.setPassword(passwordEncoder.encode(usuario.getPassword()));

        Usuario usuarioGuardado = usuarioRepository.save(usuarioCreado);

        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(String.valueOf(usuario.getRol()));

        Authentication authentication = new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getPassword(), authorities);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessage("Registro exitoso");
        authResponse.setRol(usuarioGuardado.getRol());

        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);

    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse>signIn(@RequestBody LoginRequest req){

        String username = req.getEmail();
        String password = req.getPassword();

        Authentication authentication=authenticate(username, password);

        Collection<? extends GrantedAuthority>authorities = authentication.getAuthorities();
        String rol = authorities.isEmpty()?null:authorities.iterator().next().getAuthority();

        String jwt = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessage("Login exitoso");
        authResponse.setRol(ROL_USUARIO.valueOf(rol));

        return  new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    private Authentication authenticate(String username, String password) {

        UserDetails userDetails = detallesDeUsuarioService.loadUserByUsername(username);

        if(userDetails==null){
            throw new BadCredentialsException("Nombre de usuario invalido...");
        }

        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Contrasena invalida...");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
