package com.bcode.cade.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MATERIA_BCODE")
public class MateriaBcode {
    @Id
    @Column(name = "clave_materia", nullable = false, length = 10)
    private String id;

    @Column(name = "nombre_materia", nullable = false, length = 150)
    private String nombreMateria;

    @Column(name = "horas_teoricas", nullable = false)
    private Character horasTeoricas;

    @Column(name = "horas_practicas", nullable = false)
    private Character horasPracticas;

    @Column(name = "total_creditos", nullable = false, length = 2)
    private String totalCreditos;

    @Column(name = "status_materia", nullable = false)
    private Character statusMateria;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Character getHorasTeoricas() {
        return horasTeoricas;
    }

    public void setHorasTeoricas(Character horasTeoricas) {
        this.horasTeoricas = horasTeoricas;
    }

    public Character getHorasPracticas() {
        return horasPracticas;
    }

    public void setHorasPracticas(Character horasPracticas) {
        this.horasPracticas = horasPracticas;
    }

    public String getTotalCreditos() {
        return totalCreditos;
    }

    public void setTotalCreditos(String totalCreditos) {
        this.totalCreditos = totalCreditos;
    }

    public Character getStatusMateria() {
        return statusMateria;
    }

    public void setStatusMateria(Character statusMateria) {
        this.statusMateria = statusMateria;
    }

}