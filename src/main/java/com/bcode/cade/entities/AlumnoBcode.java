package com.bcode.cade.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ALUMNO_BCODE")
public class AlumnoBcode {
    @Id
    @Column(name = "numero_control", nullable = false, length = 9)
    private String id;

    @Column(name = "nombre_alumno", nullable = false, length = 150)
    private String nombreAlumno;

    @Column(name = "ape1_alumno", nullable = false, length = 150)
    private String ape1Alumno;

    @Column(name = "ape2_alumno", length = 150)
    private String ape2Alumno;

    @Column(name = "telefono_alumno", nullable = false, length = 10)
    private String telefonoAlumno;

    @Column(name = "correo_alumno", nullable = false, length = 150)
    private String correoAlumno;

    @Column(name = "direccion_alumno", nullable = false)
    private String direccionAlumno;

    @Column(name = "fecha_nacimiento_alumno", nullable = false)
    private LocalDate fechaNacimientoAlumno;

    @Column(name = "status_alumno", nullable = false)
    private Character statusAlumno;

    @Column(name = "contrasenia_alumno", nullable = false, length = 150)
    private String contraseniaAlumno;

    @Column(name = "genero_alumno", nullable = false)
    private Character generoAlumno;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_rol_fk", nullable = false)
    private RolBcode idRolFk;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "clave_carrera_fk", nullable = false)
    private CarreraBcode claveCarreraFk;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApe1Alumno() {
        return ape1Alumno;
    }

    public void setApe1Alumno(String ape1Alumno) {
        this.ape1Alumno = ape1Alumno;
    }

    public String getApe2Alumno() {
        return ape2Alumno;
    }

    public void setApe2Alumno(String ape2Alumno) {
        this.ape2Alumno = ape2Alumno;
    }

    public String getTelefonoAlumno() {
        return telefonoAlumno;
    }

    public void setTelefonoAlumno(String telefonoAlumno) {
        this.telefonoAlumno = telefonoAlumno;
    }

    public String getCorreoAlumno() {
        return correoAlumno;
    }

    public void setCorreoAlumno(String correoAlumno) {
        this.correoAlumno = correoAlumno;
    }

    public String getDireccionAlumno() {
        return direccionAlumno;
    }

    public void setDireccionAlumno(String direccionAlumno) {
        this.direccionAlumno = direccionAlumno;
    }

    public LocalDate getFechaNacimientoAlumno() {
        return fechaNacimientoAlumno;
    }

    public void setFechaNacimientoAlumno(LocalDate fechaNacimientoAlumno) {
        this.fechaNacimientoAlumno = fechaNacimientoAlumno;
    }

    public Character getStatusAlumno() {
        return statusAlumno;
    }

    public void setStatusAlumno(Character statusAlumno) {
        this.statusAlumno = statusAlumno;
    }

    public String getContraseniaAlumno() {
        return contraseniaAlumno;
    }

    public void setContraseniaAlumno(String contraseniaAlumno) {
        this.contraseniaAlumno = contraseniaAlumno;
    }

    public Character getGeneroAlumno() {
        return generoAlumno;
    }

    public void setGeneroAlumno(Character generoAlumno) {
        this.generoAlumno = generoAlumno;
    }

    public RolBcode getIdRolFk() {
        return idRolFk;
    }

    public void setIdRolFk(RolBcode idRolFk) {
        this.idRolFk = idRolFk;
    }

    public CarreraBcode getClaveCarreraFk() {
        return claveCarreraFk;
    }

    public void setClaveCarreraFk(CarreraBcode claveCarreraFk) {
        this.claveCarreraFk = claveCarreraFk;
    }

}