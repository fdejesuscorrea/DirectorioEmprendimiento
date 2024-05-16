package com.udea.edu.co.directorio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Novedad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name="categoria")
    private Categoria categoria;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "titulo")
    private String titulo;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="img_url")
    private String img_url;

    @Column(name="cuerpo", columnDefinition="LONGTEXT")
    private String cuerpo;


    public void updatenov(Novedad un) {
        if(un.getCategoria()!=null){
            setCategoria(un.getCategoria());
        }
        if(un.getFecha()!=null){
            setFecha(un.getFecha());
        }
        if(un.categoria != null){
            setCategoria(un.getCategoria());
        }
        if(un.titulo!=null){
            setTitulo(un.getTitulo());
        }
        if(un.getDescripcion()!=null){
            setDescripcion(un.getDescripcion());
        }
        if(un.getImg_url()!=null){
            setImg_url(un.getImg_url());
        }
        if(un.cuerpo != null){
            setCuerpo(un.getCuerpo());
        }
    }
}