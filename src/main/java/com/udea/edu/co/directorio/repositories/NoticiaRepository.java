package com.udea.edu.co.directorio.repositories;

import com.udea.edu.co.directorio.entities.Noticia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NoticiaRepository extends CrudRepository<Noticia,Integer> {
    List<Noticia> findAll();
    Noticia findNoticiaById(int id);
}
