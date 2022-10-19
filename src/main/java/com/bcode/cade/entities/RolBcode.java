package com.bcode.cade.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROL_BCODE")
public class RolBcode {
    @Id
    @Column(name = "id_rol", nullable = false)
    private Byte id;

    @Column(name = "descripcion_rol", nullable = false, length = 150)
    private String descripcionRol;

    @Column(name = "status_rol", nullable = false)
    private Character statusRol;

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public Character getStatusRol() {
        return statusRol;
    }

    public void setStatusRol(Character statusRol) {
        this.statusRol = statusRol;
    }

}