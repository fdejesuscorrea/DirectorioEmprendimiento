package com.udea.edu.co.directorio.repositories;

import com.udea.edu.co.directorio.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String nombreDeUsuario);
}
