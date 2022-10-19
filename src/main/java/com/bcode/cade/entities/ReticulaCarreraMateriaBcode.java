package com.bcode.cade.entities;

import javax.persistence.*;

@Entity
@Table(name = "RETICULA_CARRERA_MATERIA_BCODE")
public class ReticulaCarreraMateriaBcode {
    @Id
    @Column(name = "id_reticula_carrera_materia", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "clave_carrera_fk", nullable = false)
    private CarreraBcode claveCarreraFk;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "clave_materia_fk", nullable = false)
    private MateriaBcode claveMateriaFk;

    @Column(name = "semestre_materia", nullable = false, length = 2)
    private String semestreMateria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarreraBcode getClaveCarreraFk() {
        return claveCarreraFk;
    }

    public void setClaveCarreraFk(CarreraBcode claveCarreraFk) {
        this.claveCarreraFk = claveCarreraFk;
    }

    public MateriaBcode getClaveMateriaFk() {
        return claveMateriaFk;
    }

    public void setClaveMateriaFk(MateriaBcode claveMateriaFk) {
        this.claveMateriaFk = claveMateriaFk;
    }

    public String getSemestreMateria() {
        return semestreMateria;
    }

    public void setSemestreMateria(String semestreMateria) {
        this.semestreMateria = semestreMateria;
    }

}