package com.udea.edu.co.directorio.services;


import com.udea.edu.co.directorio.entities.Emprendedor;
import com.udea.edu.co.directorio.entities.TipoDocumento;
import com.udea.edu.co.directorio.repositories.EmprendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprendedorServiceImpl implements EmprendedorService{

    @Autowired
    private EmprendedorRepository emprendedorRepository;

    @Override
    public Emprendedor findEmprendedorByDocumento(TipoDocumento tipoDocumento, Long numeroDocumento) throws Exception {
        Emprendedor emprendedor = emprendedorRepository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);

        if(emprendedor==null) {
            throw new Exception("Emprendedor no ha sido encontrado");
        }
        return emprendedor;
    }
}