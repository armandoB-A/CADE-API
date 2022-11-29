package com.bcode.cade.controllers;

import com.bcode.cade.dto.AlumnoBcodeDto;
import com.bcode.cade.entities.AlumnoBcode;
import com.bcode.cade.entities.CargaAcademicaBcode;
import com.bcode.cade.services.KardexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("kardex")
public class KardexController {

    @Autowired
    private KardexService kardexService;

    @GetMapping()
    public ResponseEntity<AlumnoBcodeDto> getKardex(
            @RequestParam(value = "numc") String numeroc,
            @RequestParam(value = "semestre", required = false) String semestre
    ) {
        if (semestre != null) {
            return new ResponseEntity<>(kardexService.getK(numeroc, semestre), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(kardexService.getKardex(numeroc), HttpStatus.OK);
        }
    }

}
