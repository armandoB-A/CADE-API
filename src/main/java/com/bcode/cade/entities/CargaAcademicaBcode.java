package com.bcode.cade.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CARGA_ACADEMICA_BCODE")
public class CargaAcademicaBcode {
    @Id
    @Column(name = "id_carga_academica", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "numero_control_fk", nullable = false)
    private AlumnoBcode numeroControlFk;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_horario_fk", nullable = false)
    private HorarioBcode idHorarioFk;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_opcion_fk", nullable = false)
    private OpcionBcode idOpcionFk;

    @Column(name = "calificacion", nullable = false, precision = 10)
    private BigDecimal calificacion;

    @Column(name = "status_carga_academica", nullable = false)
    private Character statusCargaAcademica;

    @Column(name = "semestre_actual", nullable = false, length = 2)
    private String semestreActual;

    @Column(name = "nivel_desempenio", nullable = false, length = 15)
    private String nivelDesempenio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AlumnoBcode getNumeroControlFk() {
        return numeroControlFk;
    }

    public void setNumeroControlFk(AlumnoBcode numeroControlFk) {
        this.numeroControlFk = numeroControlFk;
    }

    public HorarioBcode getIdHorarioFk() {
        return idHorarioFk;
    }

    public void setIdHorarioFk(HorarioBcode idHorarioFk) {
        this.idHorarioFk = idHorarioFk;
    }

    public OpcionBcode getIdOpcionFk() {
        return idOpcionFk;
    }

    public void setIdOpcionFk(OpcionBcode idOpcionFk) {
        this.idOpcionFk = idOpcionFk;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public Character getStatusCargaAcademica() {
        return statusCargaAcademica;
    }

    public void setStatusCargaAcademica(Character statusCargaAcademica) {
        this.statusCargaAcademica = statusCargaAcademica;
    }

    public String getSemestreActual() {
        return semestreActual;
    }

    public void setSemestreActual(String semestreActual) {
        this.semestreActual = semestreActual;
    }

    public String getNivelDesempenio() {
        return nivelDesempenio;
    }

    public void setNivelDesempenio(String nivelDesempenio) {
        this.nivelDesempenio = nivelDesempenio;
    }

}