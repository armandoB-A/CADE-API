package com.bcode.cade.controllers;

import com.bcode.cade.dto.AlumnoBcodeDto;
import com.bcode.cade.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("alumno")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping()
    public ResponseEntity<List<AlumnoBcodeDto>> getA(){
        return new ResponseEntity<>(alumnoService.getAlumnoBcodeRepository(), HttpStatus.OK);
    }
}
