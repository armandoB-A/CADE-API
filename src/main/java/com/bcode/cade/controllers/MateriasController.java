package com.bcode.cade.controllers;

import com.bcode.cade.entities.MateriaBcode;
import com.bcode.cade.repository.MateriaBcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("materias")
public class MateriasController {
    @Autowired
    private MateriaBcodeRepository materiaBcodeRepository;

    @GetMapping()
    public ResponseEntity<List<MateriaBcode>> getm(){
        return new ResponseEntity<List<MateriaBcode>>(materiaBcodeRepository.findAll(), HttpStatus.OK);
    }
}
