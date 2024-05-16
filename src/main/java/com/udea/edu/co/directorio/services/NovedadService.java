package com.udea.edu.co.directorio.services;

import com.udea.edu.co.directorio.entities.Novedad;
import com.udea.edu.co.directorio.request.CreateNovedadRequest;

import java.util.List;

public interface NovedadService {

    public Novedad createNovedad(CreateNovedadRequest req);

    public Novedad updateNovedad(Long NovedadId, CreateNovedadRequest updatedNovedadRequest) throws Exception;

    public void deleteNovedad(Long NovedadId) throws Exception;

    public List<Novedad> getAllNovedad();
}
