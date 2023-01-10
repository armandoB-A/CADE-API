package com.bcode.cade.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.bcode.cade.entities.AdministrativoBcode} entity
 */
@Data
public class AdministrativoSaveBcodeDto implements Serializable {
    private final Integer id;
    private final String nombreAdministrativo;
    private final String ape1Administrativo;
    private final String ape2Administrativo;
    private final String telefonoAdministrativo;
    private final String correoAdministrativo;
    private final String direccionAdministrativo;

    private final Character statusAdministrativo;
    private final String contraseniaAdministrativo;
    private final Byte idRolFkId;
}