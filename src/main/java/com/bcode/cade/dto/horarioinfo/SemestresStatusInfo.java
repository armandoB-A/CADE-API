package com.bcode.cade.dto.horarioinfo;

/**
 * A Projection for the {@link com.bcode.cade.entities.CargaAcademicaBcode} entity
 */
public interface SemestresStatusInfo {
    Character getStatusCargaAcademica();

    String getSemestreLlevado();
}