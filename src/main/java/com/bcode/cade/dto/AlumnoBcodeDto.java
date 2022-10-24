package com.bcode.cade.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AlumnoBcodeDto implements Serializable {
    private String nombreAlumno;
    private String ape1Alumno;
    private String telefonoAlumno;
    private String correoAlumno;

}
