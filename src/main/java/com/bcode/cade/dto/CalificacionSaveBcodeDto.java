package com.bcode.cade.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.bcode.cade.entities.CalificacionBcode} entity
 */
@Data
public class CalificacionSaveBcodeDto implements Serializable {
    private final Long id;
    private final Long idCargaAcademicaFk;
    private final BigDecimal calificacion;
    private final String nivelDesempenio;
    private final Character statusCalificacion;
}