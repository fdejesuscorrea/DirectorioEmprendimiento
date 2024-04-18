package com.udea.edu.co.directorio.services;

import com.udea.edu.co.directorio.entities.Usuario;

public interface UsuarioService {

    public Usuario findUsuarioByJwtToken(String jwt) throws Exception;

    public Usuario findUsuarioByEmail(String email) throws Exception;
}
