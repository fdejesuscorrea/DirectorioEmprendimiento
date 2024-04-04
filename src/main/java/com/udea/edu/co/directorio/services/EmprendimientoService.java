package com.udea.edu.co.directorio.services;


import com.udea.edu.co.directorio.entities.Emprendimiento;
import com.udea.edu.co.directorio.repositories.EmprendimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprendimientoService {

    private final EmprendimientoRepository emprendimientoRepository;

    @Autowired
    public EmprendimientoService(EmprendimientoRepository emprendimientoRepository) {
        this.emprendimientoRepository = emprendimientoRepository;
    }

    public List<Emprendimiento> findAllEmprendimientos() {
        return emprendimientoRepository.findAll();
    }

    public Emprendimiento saveEmprendimiento(Emprendimiento emprendimiento) {
        return emprendimientoRepository.save(emprendimiento);
    }

    public Emprendimiento findEmprendimientoById(int id) {
        return emprendimientoRepository.findById(id).orElse(null);
    }

    public void deleteEmprendimiento(int id) {
        emprendimientoRepository.deleteById(id);
    }
}