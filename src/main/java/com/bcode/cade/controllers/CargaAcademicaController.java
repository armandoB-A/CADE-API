package com.bcode.cade.controllers;

import com.bcode.cade.dto.CargaAcademicaBcodeDto;
import com.bcode.cade.entities.CargaAcademicaBcode;
import com.bcode.cade.services.CargaAcademicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carga")
public class CargaAcademicaController {

    @Autowired
    private CargaAcademicaService cargaAcademicaService;

    @PostMapping("/id/")
    public ResponseEntity<CargaAcademicaBcode> postCarga(
            @RequestBody CargaAcademicaBcodeDto cargaT
    ) {
        return new ResponseEntity<>(cargaAcademicaService.saveCarga(cargaT), HttpStatus.ACCEPTED);
    }
}
