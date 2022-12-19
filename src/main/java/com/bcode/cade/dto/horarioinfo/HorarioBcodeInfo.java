package com.bcode.cade.dto.horarioinfo;

/**
 * A Projection for the {@link com.bcode.cade.entities.HorarioBcode} entity
 */
public interface HorarioBcodeInfo {
    String getPeriodoSemestre();

    MateriaBcodeInfo getClaveMateriaFk();

    GrupoBcodeInfo getIdGrupoFk();
}