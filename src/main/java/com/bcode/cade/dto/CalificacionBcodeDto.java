package com.bcode.cade.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class CalificacionBcodeDto implements Serializable {

    private final String SemestreLlevado;
    private final String IdMatCarrera;
    private final String NombreMateria;
    private final String NumeroGrupo;
    private final String TotalCreditos;
    private final BigDecimal calificacion;
    private final String nivelDesempenio;
    private final String DescripcionOpcion;
    private final String OportunidadOpcion;
}