package com.bcode.cade.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "administrativo_bcode")
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

    @ManyToMany
    @JoinTable(name = "detalle_administrativo_bcode",
            joinColumns = @JoinColumn(name = "id_administrativo_fk"),
            inverseJoinColumns = @JoinColumn(name = "clave_carrera_fk"))
    private List<CarreraBcode> carreraBcodes = new ArrayList<>();

    public List<CarreraBcode> getCarreraBcodes() {
        return carreraBcodes;
    }

    public void setCarreraBcodes(List<CarreraBcode> carreraBcodes) {
        this.carreraBcodes = carreraBcodes;
    }/*
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id_administrativo_fk")
    private List<HorarioBcode> horarioBcodes = new ArrayList<>();

    public List<HorarioBcode> getHorarioBcodes() {
        return horarioBcodes;
    }

    public void setHorarioBcodes(List<HorarioBcode> horarioBcodes) {
        this.horarioBcodes = horarioBcodes;
    }*/

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

    public RolBcode getIdRolFkId() {
        return idRolFk;
    }
}