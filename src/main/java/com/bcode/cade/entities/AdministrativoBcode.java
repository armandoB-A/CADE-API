package com.bcode.cade.entities;

import javax.persistence.*;

@Entity
@Table(name = "ADMINISTRATIVO_BCODE")
public class AdministrativoBcode {
    @Id
    @Column(name = "id_administrativo", nullable = false)
    private Integer id;

    @Column(name = "nombre_administrativo", nullable = false)
    private String nombreAdministrativo;

    @Column(name = "ape1_administrativo", nullable = false)
    private String ape1Administrativo;

    @Column(name = "ape2_administrativo")
    private String ape2Administrativo;

    @Column(name = "telefono_administrativo", nullable = false, length = 10)
    private String telefonoAdministrativo;

    @Column(name = "correo_administrativo", nullable = false, length = 150)
    private String correoAdministrativo;

    @Column(name = "direccion_administrativo", nullable = false)
    private String direccionAdministrativo;

    @Column(name = "status_administrativo", nullable = false)
    private Character statusAdministrativo;

    @Column(name = "contrasenia_administrativo", nullable = false, length = 150)
    private String contraseniaAdministrativo;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_rol_fk", nullable = false)
    private RolBcode idRolFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreAdministrativo() {
        return nombreAdministrativo;
    }

    public void setNombreAdministrativo(String nombreAdministrativo) {
        this.nombreAdministrativo = nombreAdministrativo;
    }

    public String getApe1Administrativo() {
        return ape1Administrativo;
    }

    public void setApe1Administrativo(String ape1Administrativo) {
        this.ape1Administrativo = ape1Administrativo;
    }

    public String getApe2Administrativo() {
        return ape2Administrativo;
    }

    public void setApe2Administrativo(String ape2Administrativo) {
        this.ape2Administrativo = ape2Administrativo;
    }

    public String getTelefonoAdministrativo() {
        return telefonoAdministrativo;
    }

    public void setTelefonoAdministrativo(String telefonoAdministrativo) {
        this.telefonoAdministrativo = telefonoAdministrativo;
    }

    public String getCorreoAdministrativo() {
        return correoAdministrativo;
    }

    public void setCorreoAdministrativo(String correoAdministrativo) {
        this.correoAdministrativo = correoAdministrativo;
    }

    public String getDireccionAdministrativo() {
        return direccionAdministrativo;
    }

    public void setDireccionAdministrativo(String direccionAdministrativo) {
        this.direccionAdministrativo = direccionAdministrativo;
    }

    public Character getStatusAdministrativo() {
        return statusAdministrativo;
    }

    public void setStatusAdministrativo(Character statusAdministrativo) {
        this.statusAdministrativo = statusAdministrativo;
    }

    public String getContraseniaAdministrativo() {
        return contraseniaAdministrativo;
    }

    public void setContraseniaAdministrativo(String contraseniaAdministrativo) {
        this.contraseniaAdministrativo = contraseniaAdministrativo;
    }

    public RolBcode getIdRolFk() {
        return idRolFk;
    }

    public void setIdRolFk(RolBcode idRolFk) {
        this.idRolFk = idRolFk;
    }

}