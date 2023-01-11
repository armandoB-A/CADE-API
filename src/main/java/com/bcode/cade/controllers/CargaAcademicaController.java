package com.bcode.cade.controllers;

import com.bcode.cade.dto.CargaAcademicaBcodeDto1;
import com.bcode.cade.dto.horarioinfo.CargaAcademicaSemestreBcodeInfo;
import com.bcode.cade.entities.CargaAcademicaBcode;
import com.bcode.cade.services.CargaAcademicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carga")
public class CargaAcademicaController {

    @Autowired
    private CargaAcademicaService cargaAcademicaService;

    @PostMapping("/id/")
    public ResponseEntity<CargaAcademicaBcode> postCarga(
            @RequestBody CargaAcademicaBcodeDto1 cargaT
    ) {
        return new ResponseEntity<>(cargaAcademicaService.saveCarga(cargaT), HttpStatus.ACCEPTED);
    }
    @GetMapping("/exist/id/{id}/")
    public ResponseEntity<Boolean> getCargaIfExist(@PathVariable("id") String numeroC){
        return new ResponseEntity<>(cargaAcademicaService.getExist(numeroC), HttpStatus.OK);
    }

    @GetMapping("/semestre/id/{id}/semestre/{semestre}")
    public ResponseEntity<List<CargaAcademicaSemestreBcodeInfo>> getCargaSemestre(@PathVariable("id") String numeroC,
                                                                                  @PathVariable("semestre") String semestre){
        return new ResponseEntity<>(cargaAcademicaService.getCSemestre(numeroC, semestre), HttpStatus.OK);
    }

}
