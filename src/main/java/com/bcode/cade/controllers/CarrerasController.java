package com.bcode.cade.controllers;

import com.bcode.cade.dto.CarreraBcodeDto;
import com.bcode.cade.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("carreras")
public class CarrerasController {
    @Autowired
    private CarreraService carreraService;
    @GetMapping
    public ResponseEntity<List<CarreraBcodeDto>> getCarreras(){
        return new ResponseEntity<>(carreraService.getCarreraBcodeRepository(), HttpStatus.OK);
    }
}
