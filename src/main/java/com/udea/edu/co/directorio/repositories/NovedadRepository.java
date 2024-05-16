package com.udea.edu.co.directorio.repositories;
import com.udea.edu.co.directorio.entities.Novedad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NovedadRepository extends JpaRepository<Novedad,Long> {
    List<Novedad> findAll();
    //Novedad createNovedad(CreateNovedadRequest req);
    Novedad findNovedadById(long id);
    //Novedad createNoticias(Novedad noticia);
}
