package com.bcode.cade.services;

import com.bcode.cade.entities.CalificacionBcode;
import com.bcode.cade.repository.CalificacionBcodeRepository;
import com.bcode.cade.repository.CargaAcademicaBcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.List;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionBcodeRepository calificacionBcodeRepository;

    @Autowired
    private CargaAcademicaBcodeRepository cargaAcademicaBcodeRepository;

    public List<String> getCalificaciones(){
        return calificacionBcodeRepository.findSomeFields();
    }

    public List<String> getCalificacionesEmpty() {
        return calificacionBcodeRepository.findEmptyFields();
    }
}
