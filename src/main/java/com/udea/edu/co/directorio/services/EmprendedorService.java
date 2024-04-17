package com.udea.edu.co.directorio.services;

import com.udea.edu.co.directorio.entities.Emprendedor;
import com.udea.edu.co.directorio.entities.TipoDocumento;
import org.springframework.stereotype.Service;

@Service
public interface EmprendedorService {

    public Emprendedor findEmprendedorByDocumento(TipoDocumento tipoDocumento, Long numeroDocumento) throws Exception;
}
