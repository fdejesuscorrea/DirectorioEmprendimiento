package com.udea.edu.co.directorio.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "emprendedores")
public class Emprendedor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_number")
    private int idNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name="rolEmprendedor")
    private String rolEmprendedor;

    @Column(name= "estado")
    private String estado;

    @Column(name= "vinculo")
    private String vinculo;

    public int getIdNumber() {
        return idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRolEmprendedor() {
        return rolEmprendedor;
    }

    public String getEstado() {
        return estado;
    }

    public String getVinculo() {
        return vinculo;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRolEmprendedor(String rolEmprendedor) {
        this.rolEmprendedor = rolEmprendedor;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }
    // Getters and setters
}
