package com.bcode.cade.entities;

import javax.persistence.*;

@Entity
@Table(name = "DETALLE_ADMINISTRATIVO_BCODE")
public class DetalleAdministrativoBcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_adminitrativo", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_administrativo_fk", nullable = false)
    private AdministrativoBcode idAdministrativoFk;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "clave_carrera_fk", nullable = false)
    private CarreraBcode claveCarreraFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AdministrativoBcode getIdAdministrativoFk() {
        return idAdministrativoFk;
    }

    public void setIdAdministrativoFk(AdministrativoBcode idAdministrativoFk) {
        this.idAdministrativoFk = idAdministrativoFk;
    }

    public CarreraBcode getClaveCarreraFk() {
        return claveCarreraFk;
    }

    public void setClaveCarreraFk(CarreraBcode claveCarreraFk) {
        this.claveCarreraFk = claveCarreraFk;
    }

}