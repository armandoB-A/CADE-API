package com.bcode.cade.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FUNCION_ROL_BCODE")
public class FuncionRolBcode {
    @Id
    @Column(name = "id_funcion_rol", nullable = false)
    private Byte id;

    @Column(name = "descripcion_funcion_rol", nullable = false)
    private String descripcionFuncionRol;

    @Column(name = "status_funcion_rol", nullable = false)
    private Character statusFuncionRol;

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getDescripcionFuncionRol() {
        return descripcionFuncionRol;
    }

    public void setDescripcionFuncionRol(String descripcionFuncionRol) {
        this.descripcionFuncionRol = descripcionFuncionRol;
    }

    public Character getStatusFuncionRol() {
        return statusFuncionRol;
    }

    public void setStatusFuncionRol(Character statusFuncionRol) {
        this.statusFuncionRol = statusFuncionRol;
    }

}