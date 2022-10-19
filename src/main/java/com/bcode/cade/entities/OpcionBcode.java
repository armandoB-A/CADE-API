package com.bcode.cade.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OPCION_BCODE")
public class OpcionBcode {
    @Id
    @Column(name = "id_opcion", nullable = false)
    private Byte id;

    @Column(name = "descripcion_opcion", nullable = false, length = 100)
    private String descripcionOpcion;

    @Column(name = "oportunidad_opcion", nullable = false, length = 100)
    private String oportunidadOpcion;

    @Column(name = "status_opcion", nullable = false)
    private Character statusOpcion;

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getDescripcionOpcion() {
        return descripcionOpcion;
    }

    public void setDescripcionOpcion(String descripcionOpcion) {
        this.descripcionOpcion = descripcionOpcion;
    }

    public String getOportunidadOpcion() {
        return oportunidadOpcion;
    }

    public void setOportunidadOpcion(String oportunidadOpcion) {
        this.oportunidadOpcion = oportunidadOpcion;
    }

    public Character getStatusOpcion() {
        return statusOpcion;
    }

    public void setStatusOpcion(Character statusOpcion) {
        this.statusOpcion = statusOpcion;
    }

}