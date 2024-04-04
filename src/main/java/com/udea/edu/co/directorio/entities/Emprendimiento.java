package com.udea.edu.co.directorio.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "emprendimientos")
public class Emprendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "brief_description")
    private String briefDescription;

    @Column(name = "if_formalized")
    private Character ifFormalized;

    @Column(name = "email")
    private String email;

    @Column(name = "whatsapp")
    private String whatsapp;

    @Column(name = "webpage")
    private String webpage;

    @Column(name = "logo_name")
    private String logoName;


    @Column(name="super_tipo")
    private String superTipo;

    @Column(name="estado_emprendimiento")
    private String estadoEmprendimiento;

    public String getName() {
        return name;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public Character getIfFormalized() {
        return ifFormalized;
    }

    public String getEmail() {
        return email;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public String getWebpage() {
        return webpage;
    }

    public String getLogoName() {
        return logoName;
    }

    public String getSuperTipo() {
        return superTipo;
    }

    public String getEstadoEmprendimiento() {
        return estadoEmprendimiento;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public void setIfFormalized(Character ifFormalized) {
        this.ifFormalized = ifFormalized;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public void setLogoName(String logoName) {
        this.logoName = logoName;
    }

    public void setSuperTipo(String superTipo) {
        this.superTipo = superTipo;
    }

    public void setEstadoEmprendimiento(String estadoEmprendimiento) {
        this.estadoEmprendimiento = estadoEmprendimiento;
    }
    // Getters and setters
}
