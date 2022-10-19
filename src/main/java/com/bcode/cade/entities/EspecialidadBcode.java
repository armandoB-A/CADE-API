package com.bcode.cade.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESPECIALIDAD_BCODE")
public class EspecialidadBcode {
    @Id
    @Column(name = "id_especialidad", nullable = false)
    private Integer id;

    @Column(name = "nombre_especialidad", nullable = false, length = 150)
    private String nombreEspecialidad;

    @Column(name = "status_especialidad", nullable = false)
    private Character statusEspecialidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public Character getStatusEspecialidad() {
        return statusEspecialidad;
    }

    public void setStatusEspecialidad(Character statusEspecialidad) {
        this.statusEspecialidad = statusEspecialidad;
    }

}