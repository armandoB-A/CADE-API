package com.bcode.cade.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Calif {
    private final String claveMateria;
    private final String nombreMateria;
    private final String totalCreditos;
    private final BigDecimal calificacion;
    private final String periodoSemestre;
    //
    private final String descripcionOpcion;
    private final String oportunidadOpcion;

}
