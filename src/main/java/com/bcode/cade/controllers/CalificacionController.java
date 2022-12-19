package com.bcode.cade.controllers;

import com.bcode.cade.entities.CalificacionBcode;
import com.bcode.cade.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Tuple;
import java.util.List;

@RestController
@RequestMapping("/calificacion")
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;

    @GetMapping()
    public ResponseEntity<List<String>> getCalificaciones(){
        return new ResponseEntity<>(calificacionService.getCalificaciones(), HttpStatus.OK);
    }

    @GetMapping("/empty")
    public ResponseEntity<List<String>> getCalificacionesEmpty(){
        return new ResponseEntity<>(calificacionService.getCalificacionesEmpty(), HttpStatus.OK);
    }
}
