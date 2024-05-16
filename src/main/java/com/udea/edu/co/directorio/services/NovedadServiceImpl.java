package com.udea.edu.co.directorio.services;


import com.udea.edu.co.directorio.entities.Categoria;
import com.udea.edu.co.directorio.entities.Novedad;
import com.udea.edu.co.directorio.repositories.NovedadRepository;
import com.udea.edu.co.directorio.request.CreateNovedadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NovedadServiceImpl implements NovedadService {
    @Autowired
    private final NovedadRepository novedadRepository;
    @Autowired
    public NovedadServiceImpl(NovedadRepository novedadRepository) {
        this.novedadRepository = novedadRepository;
    }

    @Override
    public Novedad createNovedad(CreateNovedadRequest req) {
        Novedad novedad = new Novedad();
        //novedad.setCategoria(Categoria.valueOf(req.getMessage()));
        return novedadRepository.save(novedad);
    }

    @Override
    public Novedad updateNovedad(Long id, CreateNovedadRequest req) throws Exception {
        Novedad n = novedadRepository.findNovedadById(id);
        Novedad un = req.req2nov();
        n.updatenov(un);
        return novedadRepository.save(n);
    }

    @Override
    public void deleteNovedad(Long NovedadId) throws Exception {

    }

    @Override
    public List<Novedad> getAllNovedad() {
        return null;
    }

    /*
    @Autowired
    public NovedadServiceImpl(NovedadRepository novedadRepository) {
        this.novedadRepository = novedadRepository;
    }

    public List<Novedad> findAllNoticias() {
        return novedadRepository.findAll();
    }
    public Novedad findNoticiaById(int id) {
        return novedadRepository.findById(id).orElse(null);
    }
    public Novedad createNovedad(CreateNovedadRequest req){ return novedadRepository.createNovedad(); }*/

}
