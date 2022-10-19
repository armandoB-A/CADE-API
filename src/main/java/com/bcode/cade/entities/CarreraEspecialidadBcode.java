package com.bcode.cade.entities;

import javax.persistence.*;

@Entity
@Table(name = "CARRERA_ESPECIALIDAD_BCODE")
public class CarreraEspecialidadBcode {
    @Id
    @Column(name = "id_carrera_especialidad", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "clave_carrera_fk", nullable = false)
    private CarreraBcode claveCarreraFk;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_especialidad_fk", nullable = false)
    private EspecialidadBcode idEspecialidadFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarreraBcode getClaveCarreraFk() {
        return claveCarreraFk;
    }

    public void setClaveCarreraFk(CarreraBcode claveCarreraFk) {
        this.claveCarreraFk = claveCarreraFk;
    }

    public EspecialidadBcode getIdEspecialidadFk() {
        return idEspecialidadFk;
    }

    public void setIdEspecialidadFk(EspecialidadBcode idEspecialidadFk) {
        this.idEspecialidadFk = idEspecialidadFk;
    }

}