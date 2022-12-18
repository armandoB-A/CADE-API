package com.bcode.cade.controllers;

import com.bcode.cade.entities.MateriaBcode;
import com.bcode.cade.dto.horarioinfo.HorarioBcodeInfo;
import com.bcode.cade.repository.MateriaBcodeRepository;
import com.bcode.cade.services.MateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("materias")
public class MateriasController {
    @Autowired
    private MateriaBcodeRepository materiaBcodeRepository;
    @Autowired
    private MateriasService materiasService;

    @GetMapping()
    public ResponseEntity<List<MateriaBcode>> getm(){
        return new ResponseEntity<>(materiaBcodeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/carrera/{carrera}")
    public ResponseEntity<List<HorarioBcodeInfo>> getMateriasCarrera(@PathVariable(value = "carrera") String carrera){
        return new ResponseEntity<>(materiasService.getMateriasByCarrera2(carrera), HttpStatus.OK);
    }
}
