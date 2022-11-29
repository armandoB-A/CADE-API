package com.bcode.cade.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class AlumnoSaveBcodeDto implements Serializable {
    private final String id;
    private final String nombreAlumno;
    private final String ape1Alumno;
    private final String ape2Alumno;
    private final String telefonoAlumno;
    private final String correoAlumno;
    private final String direccionAlumno;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private final LocalDate fechaNacimientoAlumno;
    private final String contraseniaAlumno;
    private final Character generoAlumno;
    private final String claveCarreraFk;
}