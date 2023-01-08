package com.bcode.cade.dto.horarioinfo;

/**
 * A Projection for the {@link com.bcode.cade.entities.HorarioBcode} entity
 */
public interface GruposAdministrativo {
    MateriaBcodeInfo1 getClaveMateriaFk();

    GrupoBcodeInfo1 getIdGrupoFk();

    /**
     * A Projection for the {@link com.bcode.cade.entities.MateriaBcode} entity
     */
    interface MateriaBcodeInfo1 {
        String getId();

        String getNombreMateria();

        Character getHorasTeoricas();

        Character getHorasPracticas();

        String getTotalCreditos();
    }

    /**
     * A Projection for the {@link com.bcode.cade.entities.GrupoBcode} entity
     */
    interface GrupoBcodeInfo1 {
        String getNumeroGrupo();
    }
}