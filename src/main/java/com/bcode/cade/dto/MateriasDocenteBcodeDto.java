package com.bcode.cade.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.bcode.cade.entities.HorarioBcode} entity
 */
@Data
public class MateriasDocenteBcodeDto implements Serializable {
    private final String claveMateriaFkId;
    private final String claveCarreraFkId;
    private final Integer idGrupoFkId;
    private final String periodoSemestre;
}