package com.udea.edu.co.directorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DirectorioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DirectorioApplication.class, args);
	}

	@GetMapping("/")
	public String apiRoot(){
		return "Bienvenido al directorio de Emprendimiento";
	}
}
