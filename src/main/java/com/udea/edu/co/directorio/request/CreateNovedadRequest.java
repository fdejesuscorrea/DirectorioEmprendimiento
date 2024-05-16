package com.udea.edu.co.directorio.request;

import com.udea.edu.co.directorio.entities.Categoria;
import com.udea.edu.co.directorio.entities.Novedad;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CreateNovedadRequest {
    private String categoria;
    private String titulo;
    private String descripcion;
    private String img_url;
    private String cuerpo;
    public Novedad req2nov(){
        Novedad n = new Novedad();
        n.setCategoria(Categoria.valueOf(this.categoria));
        n.setDescripcion(this.descripcion);
        n.setCuerpo(this.cuerpo);
        n.setFecha(LocalDateTime.now());
        n.setTitulo(this.titulo);
        n.setImg_url(this.img_url);
        return n;
    }
}
