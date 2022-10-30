package com.bcode.cade.entities;

import javax.persistence.*;

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

    @Column(name = "status_carga_academica", nullable = false)
    private Character statusCargaAcademica;

    @Column(name = "semestre_llevado", nullable = false, length = 2)
    private String semestreLlevado;

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

    public Character getStatusCargaAcademica() {
        return statusCargaAcademica;
    }

    public void setStatusCargaAcademica(Character statusCargaAcademica) {
        this.statusCargaAcademica = statusCargaAcademica;
    }

    public String getSemestreLlevado() {
        return semestreLlevado;
    }

    public void setSemestreLlevado(String semestreLlevado) {
        this.semestreLlevado = semestreLlevado;
    }

}