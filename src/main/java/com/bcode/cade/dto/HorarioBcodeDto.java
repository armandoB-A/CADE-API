package com.bcode.cade.dto;

import com.bcode.cade.entities.GrupoBcode;
import com.bcode.cade.entities.MateriaBcode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class HorarioBcodeDto implements Serializable {
    MateriaBcode claveMateriaFk;
    GrupoBcode idGrupoFk;
    String periodoSemestre;
}