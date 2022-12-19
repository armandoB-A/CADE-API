package com.bcode.cade.services;

import com.bcode.cade.dto.CargaAcademicaBcodeDto;
import com.bcode.cade.entities.CargaAcademicaBcode;
import com.bcode.cade.repository.AlumnoBcodeRepository;
import com.bcode.cade.repository.CargaAcademicaBcodeRepository;
import com.bcode.cade.repository.HorarioBcodeRepository;
import com.bcode.cade.repository.OpcionBcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CargaAcademicaService {
    @Autowired
    private CargaAcademicaBcodeRepository cargaAcademicaBcodeRepository;
    @Autowired
    private AlumnoBcodeRepository alumnoBcodeRepository;
    @Autowired
    private HorarioBcodeRepository horarioBcodeRepository;

    @Autowired
    private OpcionBcodeRepository opcionBcodeRepository;

    public CargaAcademicaBcode saveCarga(CargaAcademicaBcodeDto cargaT) {
        return cargaAcademicaBcodeRepository.save(dtoToEntity(cargaT));
    }

    private CargaAcademicaBcode dtoToEntity(CargaAcademicaBcodeDto cargaT) {
        CargaAcademicaBcode cargaAcademicaBcode = new CargaAcademicaBcode();
        cargaAcademicaBcode.setNumeroControlFk(alumnoBcodeRepository.findById(cargaT.getNumeroControlFkId()).get());
        cargaAcademicaBcode.setIdHorarioFk(horarioBcodeRepository.findById(cargaT.getIdHorarioFkId()).get());
        cargaAcademicaBcode.setIdOpcionFk(opcionBcodeRepository.findById(cargaT.getIdOpcionFkId()).get());
        cargaAcademicaBcode.setStatusCargaAcademica(cargaT.getStatusCargaAcademica());
        cargaAcademicaBcode.setSemestreLlevado(cargaT.getSemestreLlevado());
        return cargaAcademicaBcode;
    }
}
