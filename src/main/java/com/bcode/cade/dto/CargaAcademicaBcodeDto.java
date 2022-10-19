package com.bcode.cade.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CargaAcademicaBcodeDto implements Serializable {
    private final String numeroControl;
    private final String nombreAlumno;
    private final List<Calif> lista_de_calificaciones;
    private final String semestreActual;
}
