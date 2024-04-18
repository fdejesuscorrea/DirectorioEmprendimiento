package com.udea.edu.co.directorio.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;

    private String password;
}
