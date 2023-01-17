package com.bcode.cade.controllers;

import com.bcode.cade.dto.HorarioBcodeInfo;
import com.bcode.cade.dto.horarioinfo.GruposInfo;
import com.bcode.cade.dto.horarioinfo.CargaAcademicaBcodeInfo;
import com.bcode.cade.services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/horario")
public class HorarioController {
    @Autowired
    private HorarioService horarioService;

    @GetMapping("/grupos/carrera/{carrera}")
    public ResponseEntity<List<GruposInfo>> getGrupos(@PathVariable(value = "carrera") String carrera){
        return new ResponseEntity<>(horarioService.getGrupos(carrera), HttpStatus.OK );
    }
    @GetMapping("/grupos/carrerass/{carrera}")
    public ResponseEntity<List<HorarioBcodeInfo>> getGruposCarrera(@PathVariable(value = "carrera") String carrera){
        return new ResponseEntity<>(horarioService.getGruposCarr(carrera), HttpStatus.OK );
    }
    @GetMapping("/alumnos/grupo/{grupo}/")
    public ResponseEntity<List<CargaAcademicaBcodeInfo>> getAlumn(@PathVariable(value = "grupo") String grupo){
        return new ResponseEntity<>(horarioService.getAlumn(grupo), HttpStatus.OK );
    }
}
