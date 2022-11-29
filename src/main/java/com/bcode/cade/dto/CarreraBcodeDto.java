package com.bcode.cade.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CarreraBcodeDto implements Serializable {
    private String id;
    private String descripcionCarrera;
}