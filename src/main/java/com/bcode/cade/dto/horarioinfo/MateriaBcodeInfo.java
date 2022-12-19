package com.bcode.cade.dto.horarioinfo;

/**
 * A Projection for the {@link com.bcode.cade.entities.MateriaBcode} entity
 */
public interface MateriaBcodeInfo {
    String getId();

    String getNombreMateria();

    Character getHorasTeoricas();

    Character getHorasPracticas();

    String getTotalCreditos();

    Character getStatusMateria();
}