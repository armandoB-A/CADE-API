package com.bcode.cade.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AlumnoBcodeDto implements Serializable {
    private final String NumeroControl;
    private final String NombreAlumno;
    private final String Ape1Alumno;
    private final String Ape2Alumno;
    private final String ClaveCarrera;
    private final List<CalificacionBcodeDto> calificacionBcodeDtoList;
}
