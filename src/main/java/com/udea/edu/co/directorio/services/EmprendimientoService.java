package com.udea.edu.co.directorio.services;

import com.udea.edu.co.directorio.entities.Emprendimiento;
import com.udea.edu.co.directorio.request.CreateEmprendimientoRequest;

import java.util.List;

public interface EmprendimientoService {

    public Emprendimiento createEmeprendimiento(CreateEmprendimientoRequest req);

    public Emprendimiento updateEmprendimiento(Long emprendimientoId, CreateEmprendimientoRequest updatedEmprendimientoRequest) throws Exception;

    public void deleteEmprendimiento(Long emprendimientoId) throws Exception;

    public List<Emprendimiento> getAllEmprendimientos();

    public List<Emprendimiento> searchEmprendimiento(String keyword);

    public Emprendimiento  findEmprendimientoById(Long emprendimientoId) throws Exception;

    public Emprendimiento getEmprendimientoByEmprendedor(Long emprendedorId) throws Exception;

    public Emprendimiento updateEmprendimientoFormalizacion(Long id)throws Exception;
}
