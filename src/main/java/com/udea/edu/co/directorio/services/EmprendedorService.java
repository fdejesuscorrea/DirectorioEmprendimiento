package com.udea.edu.co.directorio.services;


import com.udea.edu.co.directorio.entities.Emprendedor;
import com.udea.edu.co.directorio.repositories.EmprendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprendedorService {

    private final EmprendedorRepository emprendedorRepository;

    @Autowired
    public EmprendedorService(EmprendedorRepository emprendedorRepository) {
        this.emprendedorRepository = emprendedorRepository;
    }


    public List<Emprendedor> findAllEmprendedores() {
        return emprendedorRepository.findAll();
    }

    public Emprendedor saveEmprendedor(Emprendedor emprendedor) {
        return emprendedorRepository.save(emprendedor);
    }

    public Emprendedor findEmprendedorById(int id) {
        return emprendedorRepository.findById(id).orElse(null);
    }

    public void deleteEmprendedor(int id) {
        emprendedorRepository.deleteById(id);
    }
}