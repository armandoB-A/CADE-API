package com.bcode.cade.dto.horarioinfo;

/**
 * A Projection for the {@link com.bcode.cade.entities.HorarioBcode} entity
 */
public interface GruposInfo {
    GrupoBcodeInfo getIdGrupoFk();

    /**
     * A Projection for the {@link com.bcode.cade.entities.GrupoBcode} entity
     */
    interface GrupoBcodeInfo {
        String getNumeroGrupo();
    }
}