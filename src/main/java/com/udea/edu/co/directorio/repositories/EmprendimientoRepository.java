package com.udea.edu.co.directorio.repositories;

import com.udea.edu.co.directorio.entities.Emprendimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmprendimientoRepository extends JpaRepository<Emprendimiento, Long> {

    //Primero selecciona entidades de tipo emprendimiento de la base de datos, donde el nombre coincida
    //Se hace el nombre del emprendimiento a minusculas para compararo sin distinguir mayusculas y minusculas
    //% alrededor del query hace qye se busque el nombre del emprendimiento que tenga el valor query independiente
    //minusculas y mayusculas
    //
    @Query("Select e FROM Emprendimiento e WHERE lower(e.nombre) LIKE lower(concat('%',:query,'%'))")
    List<Emprendimiento> findBySearchQuery(String query);

    Emprendimiento findByFundadoresId(Long fundadorId);
}
