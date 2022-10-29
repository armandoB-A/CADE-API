package com.bcode.cade.services;

import com.bcode.cade.dto.AlumnoBcodeDto;
import com.bcode.cade.dto.CalificacionBcodeDto;
import com.bcode.cade.entities.AlumnoBcode;
import com.bcode.cade.repository.AlumnoBcodeRepository;
import com.bcode.cade.repository.CalificacionBcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Tuple;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class KardexService {
    @Autowired
    private AlumnoBcodeRepository alumnoBcodeRepository;

    @Autowired
    private CalificacionBcodeRepository calificacionBcodeRepository;

    /*
        public AlumnoBcode getKardex(String numeroControl) {
            try {
                entityToDto(alumnoBcodeRepository.findById(numeroControl).get());
                return alumnoBcodeRepository.findById(numeroControl).get();
            } catch (Exception ex) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El numero de control : " + numeroControl + " no se encuentra registrado", ex);
            }
        }
    */
    public AlumnoBcodeDto getK(String numeroControl) {
        try {
            return entityToDto(calificacionBcodeRepository.buscarCargaByNumC(numeroControl), numeroControl, alumnoBcodeRepository.findById(numeroControl).get());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El numero de control : " + numeroControl + " no se encuentra registrado", ex);
        }
    }

    private AlumnoBcodeDto entityToDto(List<Tuple> cargaAcademicaBcodes, String numeroControl, AlumnoBcode alumnoBcode) {
        AlumnoBcodeDto alumno;
        List<CalificacionBcodeDto> listaCalif = new ArrayList<>();
        for (Tuple c : cargaAcademicaBcodes) {
            listaCalif.add(new CalificacionBcodeDto(
                    ((String) c.get("semestre")),
                    (String) c.get("clavecrr"),
                    (String) c.get("materia"),
                    (String) c.get("grupo"),
                    (String) c.get("totalc"),
                    (BigDecimal) c.get("calificacion"),
                    (String) c.get("niveld"),
                    (String) c.get("op"),
                    (String) c.get("opd")
            ));
        }
        return new AlumnoBcodeDto(
                numeroControl, alumnoBcode.getNombreAlumno(), alumnoBcode.getApe1Alumno(),
                alumnoBcode.getApe2Alumno(),alumnoBcode.getClaveCarreraFk().getDescripcionCarrera(),listaCalif
        );

    }
/*
    public List<CargaAcademicaBcodeDto> getKs(String numeroc, String carrera) {
        try {
            return entityToDto(cargaAcademicaBcodeRepository.buscarCargaByNumC(numeroc), numeroc);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El numero de control : " + numeroc + " no se encuentra registrado", ex);
        }
    }*/
}
