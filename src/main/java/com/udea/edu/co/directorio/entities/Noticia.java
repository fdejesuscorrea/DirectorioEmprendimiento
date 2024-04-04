package com.udea.edu.co.directorio.entities;

import jakarta.persistence.*;

@Entity
@Table(name="noticias")
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name="cathegory")
    private String cathegory;

    @Column(name = "date")
    private String date;

    @Column(name = "tittle")
    private String tittle;

    @Column(name="description")
    private String description;

    @Column(name="img_url")
    private String img_url;

    @Column(name="body", columnDefinition="LONGTEXT")
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCathegory() {
        return cathegory;
    }

    public void setCathegory(String cathegory) {
        this.cathegory = cathegory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}