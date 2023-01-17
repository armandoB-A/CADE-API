package com.bcode.cade.dto;

/**
 * A Projection for the {@link com.bcode.cade.entities.HorarioBcode} entity
 */
public interface HorarioBcodeInfo {
    GrupoBcodeInfo getIdGrupoFk();

    /**
     * A Projection for the {@link com.bcode.cade.entities.GrupoBcode} entity
     */
    interface GrupoBcodeInfo {
        Integer getId();

        String getNumeroGrupo();
    }
}