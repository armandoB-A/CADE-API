package com.bcode.cade.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.bcode.cade.entities.CalificacionBcode} entity
 */
@Data
public class CalificacionSaveBcodeDtoV1 implements Serializable {
    private final Long idCargaAcademicaFkId;
    private final BigDecimal calificacion;
    private final String nivelDesempenio;
    private final Character statusCalificacion;
}