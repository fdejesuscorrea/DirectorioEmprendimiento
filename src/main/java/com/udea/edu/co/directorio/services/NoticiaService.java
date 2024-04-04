package com.udea.edu.co.directorio.services;


import com.udea.edu.co.directorio.entities.Noticia;
import com.udea.edu.co.directorio.repositories.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaService {
    private final NoticiaRepository noticiaRepository;

    @Autowired
    public NoticiaService(NoticiaRepository noticiaRepository) {
        this.noticiaRepository = noticiaRepository;
    }

    public List<Noticia> findAllNoticias() {
        return noticiaRepository.findAll();
    }
    public Noticia findNoticiaById(int id) {
        return noticiaRepository.findById(id).orElse(null);
    }
}
