package com.udea.edu.co.directorio.request;

import com.udea.edu.co.directorio.entities.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateEmprendimientoRequest {

    private Long id;
    private String nombre;
    private String resumen;
    private boolean formalizada;
    private String nombreLogo;
    private String descripcion;
    private List<Sector> sectores;
    private List<Servicio> servicios;
    private List<Emprendedor> fundadores;
    private InformacionDeContacto informacionDeContacto;
    private EtapaMaduracion etapa;

}
