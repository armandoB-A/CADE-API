package com.bcode.cade.services;

import com.bcode.cade.dto.CargaAcademicaBcodeDto1;
import com.bcode.cade.dto.horarioinfo.CargaAcademicaSemestreBcodeInfo;
import com.bcode.cade.entities.CargaAcademicaBcode;
import com.bcode.cade.repository.AlumnoBcodeRepository;
import com.bcode.cade.repository.CargaAcademicaBcodeRepository;
import com.bcode.cade.repository.HorarioBcodeRepository;
import com.bcode.cade.repository.OpcionBcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Boolean getExist(String numc) {
        return cargaAcademicaBcodeRepository.existsByNumeroControlFk_IdAndNumeroControlFk_StatusAlumno(numc, '0');
    }

    public List<CargaAcademicaSemestreBcodeInfo> getCSemestre(String numc, String semestre) {
        return cargaAcademicaBcodeRepository.findByNumeroControlFk_IdAndSemestreLlevadoOrderByIdHorarioFk_ClaveMateriaFk_NombreMateriaAsc(numc, semestre);
    }
    public CargaAcademicaBcode saveCarga(CargaAcademicaBcodeDto1 cargaT) {
        return cargaAcademicaBcodeRepository.save(dtoToEntity(cargaT));
    }

    private CargaAcademicaBcode dtoToEntity(CargaAcademicaBcodeDto1 cargaT) {
        CargaAcademicaBcode cargaAcademicaBcode = new CargaAcademicaBcode();
        cargaAcademicaBcode.setNumeroControlFk(alumnoBcodeRepository.findById(cargaT.getNumeroControlFkId()).get());
        cargaAcademicaBcode.setIdHorarioFk(horarioBcodeRepository.findByClaveMateriaFk_Id(cargaT.getIdHorarioFkClaveMateriaFkId()));
        cargaAcademicaBcode.setIdOpcionFk(opcionBcodeRepository.findById(cargaT.getIdOpcionFkId()).get());
        cargaAcademicaBcode.setStatusCargaAcademica(cargaT.getStatusCargaAcademica());
        cargaAcademicaBcode.setSemestreLlevado(cargaT.getSemestreLlevado());
        return cargaAcademicaBcode;
    }
}
