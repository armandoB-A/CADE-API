package com.bcode.cade.controllers;

import com.bcode.cade.dto.Inicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicio")
public class InicioController {
    @GetMapping
    public ResponseEntity<Inicio> getInit(){
        return new ResponseEntity<>(new Inicio("Bienvenido"), HttpStatus.OK);
    }
    @GetMapping("/init")
    public ResponseEntity<String> getI(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
