package com.udea.edu.co.directorio.repositories;

import com.udea.edu.co.directorio.entities.Emprendedor;
import com.udea.edu.co.directorio.entities.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprendedorRepository extends JpaRepository<Emprendedor, Long> {

    public Emprendedor findByEmail(String email);

    public Emprendedor findByTipoDocumentoAndNumeroDocumento(TipoDocumento tipoDocumento, long numeroDcoumento);
}