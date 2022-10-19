package com.bcode.cade.entities;

import javax.persistence.*;

@Entity
@Table(name = "DETALLE_ROL_BCODE")
public class DetalleRolBcode {
    @Id
    @Column(name = "id_detalle_rol", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_rol_fk", nullable = false)
    private RolBcode idRolFk;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_funcion_rol_fk", nullable = false)
    private FuncionRolBcode idFuncionRolFk;

    @Column(name = "status_detalle_rol", nullable = false)
    private Character statusDetalleRol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RolBcode getIdRolFk() {
        return idRolFk;
    }

    public void setIdRolFk(RolBcode idRolFk) {
        this.idRolFk = idRolFk;
    }

    public FuncionRolBcode getIdFuncionRolFk() {
        return idFuncionRolFk;
    }

    public void setIdFuncionRolFk(FuncionRolBcode idFuncionRolFk) {
        this.idFuncionRolFk = idFuncionRolFk;
    }

    public Character getStatusDetalleRol() {
        return statusDetalleRol;
    }

    public void setStatusDetalleRol(Character statusDetalleRol) {
        this.statusDetalleRol = statusDetalleRol;
    }

}