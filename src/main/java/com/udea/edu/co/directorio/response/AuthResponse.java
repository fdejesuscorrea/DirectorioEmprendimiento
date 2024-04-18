package com.udea.edu.co.directorio.response;

import com.udea.edu.co.directorio.entities.ROL_USUARIO;
import lombok.Data;

@Data
public class AuthResponse {

    private String jwt;

    private String message;

    private ROL_USUARIO rol;
}
