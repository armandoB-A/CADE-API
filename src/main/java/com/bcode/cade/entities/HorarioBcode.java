package com.bcode.cade.entities;

import javax.persistence.*;

@Entity
@Table(name = "HORARIO_BCODE")
public class HorarioBcode {
    @Id
    @Column(name = "id_horario", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "clave_materia_fk", nullable = false)
    private MateriaBcode claveMateriaFk;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "clave_carrera_fk", nullable = false)
    private CarreraBcode claveCarreraFk;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_administrativo_fk", nullable = false)
    private AdministrativoBcode idAdministrativoFk;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_grupo_fk", nullable = false)
    private GrupoBcode idGrupoFk;

    @Column(name = "periodo_semestre", nullable = false, length = 6)
    private String periodoSemestre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MateriaBcode getClaveMateriaFk() {
        return claveMateriaFk;
    }

    public void setClaveMateriaFk(MateriaBcode claveMateriaFk) {
        this.claveMateriaFk = claveMateriaFk;
    }

    public CarreraBcode getClaveCarreraFk() {
        return claveCarreraFk;
    }

    public void setClaveCarreraFk(CarreraBcode claveCarreraFk) {
        this.claveCarreraFk = claveCarreraFk;
    }

    public AdministrativoBcode getIdAdministrativoFk() {
        return idAdministrativoFk;
    }

    public void setIdAdministrativoFk(AdministrativoBcode idAdministrativoFk) {
        this.idAdministrativoFk = idAdministrativoFk;
    }

    public GrupoBcode getIdGrupoFk() {
        return idGrupoFk;
    }

    public void setIdGrupoFk(GrupoBcode idGrupoFk) {
        this.idGrupoFk = idGrupoFk;
    }

    public String getPeriodoSemestre() {
        return periodoSemestre;
    }

    public void setPeriodoSemestre(String periodoSemestre) {
        this.periodoSemestre = periodoSemestre;
    }

}