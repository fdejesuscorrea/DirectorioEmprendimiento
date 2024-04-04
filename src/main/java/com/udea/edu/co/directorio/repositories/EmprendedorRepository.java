package com.udea.edu.co.directorio.repositories;

import com.udea.edu.co.directorio.entities.Emprendedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprendedorRepository extends CrudRepository<Emprendedor, Integer> {
    List<Emprendedor> findAll();

}