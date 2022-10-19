package com.bcode.cade.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARRERA_BCODE")
public class CarreraBcode {
    @Id
    @Column(name = "clave_carrera", nullable = false, length = 25)
    private String id;

    @Column(name = "descripcion_carrera", nullable = false)
    private String descripcionCarrera;

    @Column(name = "status_carrera", nullable = false)
    private Character statusCarrera;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcionCarrera() {
        return descripcionCarrera;
    }

    public void setDescripcionCarrera(String descripcionCarrera) {
        this.descripcionCarrera = descripcionCarrera;
    }

    public Character getStatusCarrera() {
        return statusCarrera;
    }

    public void setStatusCarrera(Character statusCarrera) {
        this.statusCarrera = statusCarrera;
    }

}