package com.bcode.cade.entities;

import javax.persistence.*;

@Entity
@Table(name = "RETICULA_BCODE")
public class ReticulaBcode {
    @Id
    @Column(name = "clave_reticula", nullable = false, length = 25)
    private String id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_especialidad_fk", nullable = false)
    private EspecialidadBcode idEspecialidadFk;

    @Column(name = "plan_reticula", nullable = false, length = 14)
    private String planReticula;

    @Column(name = "status_reticula", nullable = false)
    private Character statusReticula;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EspecialidadBcode getIdEspecialidadFk() {
        return idEspecialidadFk;
    }

    public void setIdEspecialidadFk(EspecialidadBcode idEspecialidadFk) {
        this.idEspecialidadFk = idEspecialidadFk;
    }

    public String getPlanReticula() {
        return planReticula;
    }

    public void setPlanReticula(String planReticula) {
        this.planReticula = planReticula;
    }

    public Character getStatusReticula() {
        return statusReticula;
    }

    public void setStatusReticula(Character statusReticula) {
        this.statusReticula = statusReticula;
    }

}