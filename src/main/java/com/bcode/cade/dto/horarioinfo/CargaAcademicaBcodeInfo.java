package com.bcode.cade.dto.horarioinfo;

/**
 * A Projection for the {@link com.bcode.cade.entities.CargaAcademicaBcode} entity
 */
public interface CargaAcademicaBcodeInfo {
    AlumnoBcodeInfo getNumeroControlFk();

    /**
     * A Projection for the {@link com.bcode.cade.entities.AlumnoBcode} entity
     */
    interface AlumnoBcodeInfo {
        String getId();

        String getNombreAlumno();

        String getApe1Alumno();

        String getApe2Alumno();
    }
}