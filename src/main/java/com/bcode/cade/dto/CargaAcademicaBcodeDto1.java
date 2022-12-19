package com.bcode.cade.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.bcode.cade.entities.CargaAcademicaBcode} entity
 */
@Data
public class CargaAcademicaBcodeDto1 implements Serializable {
    private final String numeroControlFkId;
    private final String idHorarioFkClaveMateriaFkId;
    private final Byte idOpcionFkId;
    private final Character statusCargaAcademica;
    private final String semestreLlevado;
}