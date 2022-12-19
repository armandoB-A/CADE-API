package com.bcode.cade.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CALIFICACION_BCODE")
public class CalificacionBcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_carga_academica_fk", nullable = false)
    private CargaAcademicaBcode idCargaAcademicaFk;

    @Column(name = "calificacion", nullable = false, precision = 10)
    private BigDecimal calificacion;

    @Column(name = "nivel_desempenio", nullable = false, length = 15)
    private String nivelDesempenio;

    @Column(name = "status_calificacion", nullable = false)
    private Character statusCalificacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CargaAcademicaBcode getIdCargaAcademicaFk() {
        return idCargaAcademicaFk;
    }

    public void setIdCargaAcademicaFk(CargaAcademicaBcode idCargaAcademicaFk) {
        this.idCargaAcademicaFk = idCargaAcademicaFk;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public String getNivelDesempenio() {
        return nivelDesempenio;
    }

    public void setNivelDesempenio(String nivelDesempenio) {
        this.nivelDesempenio = nivelDesempenio;
    }

    public Character getStatusCalificacion() {
        return statusCalificacion;
    }

    public void setStatusCalificacion(Character statusCalificacion) {
        this.statusCalificacion = statusCalificacion;
    }

}