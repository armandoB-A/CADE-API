package com.bcode.cade.dto.horarioinfo;

/**
 * A Projection for the {@link com.bcode.cade.entities.CargaAcademicaBcode} entity
 */
public interface CargaAcademicaSemestreBcodeInfo {
    Long getId();

    Character getStatusCargaAcademica();

    HorarioBcodeInfo1 getIdHorarioFk();

    OpcionBcodeInfo getIdOpcionFk();

    /**
     * A Projection for the {@link com.bcode.cade.entities.HorarioBcode} entity
     */
    interface HorarioBcodeInfo1 {
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

    /**
     * A Projection for the {@link com.bcode.cade.entities.OpcionBcode} entity
     */
    interface OpcionBcodeInfo {
        String getDescripcionOpcion();

        String getOportunidadOpcion();
    }
}