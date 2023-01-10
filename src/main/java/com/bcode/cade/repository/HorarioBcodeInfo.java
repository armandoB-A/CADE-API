package com.bcode.cade.repository;

/**
 * A Projection for the {@link com.bcode.cade.entities.HorarioBcode} entity
 */
public interface HorarioBcodeInfo {
    MateriaBcodeInfo getClaveMateriaFk();

    /**
     * A Projection for the {@link com.bcode.cade.entities.MateriaBcode} entity
     */
    interface MateriaBcodeInfo {
        String getId();

        String getNombreMateria();

        Character getHorasTeoricas();

        Character getHorasPracticas();

        String getTotalCreditos();
    }
}