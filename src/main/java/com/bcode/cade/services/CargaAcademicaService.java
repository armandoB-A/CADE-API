package com.bcode.cade.services;

import com.bcode.cade.dto.CargaAcademicaBcodeDto1;
import com.bcode.cade.dto.horarioinfo.CargaAcademicaSemestreBcodeInfo;
import com.bcode.cade.dto.horarioinfo.GruposInfo;
import com.bcode.cade.dto.horarioinfo.SemestreInfo;
import com.bcode.cade.entities.CargaAcademicaBcode;
import com.bcode.cade.repository.AlumnoBcodeRepository;
import com.bcode.cade.repository.CargaAcademicaBcodeRepository;
import com.bcode.cade.repository.HorarioBcodeRepository;
import com.bcode.cade.repository.OpcionBcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        if (!cargaAcademicaBcodeRepository.existsByNumeroControlFk_IdAndIdHorarioFk_Id(
                cargaT.getNumeroControlFkId(),
                horarioBcodeRepository.findByClaveMateriaFk_Id(cargaT.getIdHorarioFkClaveMateriaFkId()).getId())
        ) {
            return cargaAcademicaBcodeRepository.save(dtoToEntity(cargaT));
        } else {
            CargaAcademicaBcode c = cargaAcademicaBcodeRepository.findByNumeroControlFk_IdAndIdHorarioFk_Id(
                    cargaT.getNumeroControlFkId(), horarioBcodeRepository.findByClaveMateriaFk_Id(cargaT.getIdHorarioFkClaveMateriaFkId()).getId());
            c.setIdOpcionFk(opcionBcodeRepository.findById(cargaT.getIdOpcionFkId()).get());
            c.setStatusCargaAcademica(cargaT.getStatusCargaAcademica());
            c.setSemestreLlevado(cargaT.getSemestreLlevado());
            return c;
        }

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

    public List<CargaAcademicaBcode> putStatusSemestre(String numeroC, String semestre, String status) {
        List<CargaAcademicaBcode> cargaAcademicaBcodes = cargaAcademicaBcodeRepository.findByNumeroControlFk_IdAndSemestreLlevadoOrderByIdHorarioFk_ClaveMateriaFk_NombreMateriaAsc11(numeroC, semestre);
        List<CargaAcademicaBcode> cargaActualizada = updateStatus(cargaAcademicaBcodes, status);
        cargaAcademicaBcodeRepository.saveAll(cargaActualizada);
        return cargaAcademicaBcodeRepository.saveAll(cargaActualizada);
    }

    private List<CargaAcademicaBcode> updateStatus(List<CargaAcademicaBcode> cargaAcademicaBcodes, String status) {
        char st = status.charAt(0);
        cargaAcademicaBcodes.forEach(c -> c.setStatusCargaAcademica(st));
        return cargaAcademicaBcodes;
    }

    public List<SemestreInfo> getSemestres(String numeroC) {
        ArrayList<SemestreInfo> s = new ArrayList<>(cargaAcademicaBcodeRepository.findDistinctByNumeroControlFk_IdOrderBySemestreLlevadoAsc(numeroC).stream()
                .collect(Collectors.toMap(SemestreInfo::getSemestreLlevado, e -> e, (v1, v2) -> v1))
                .values());
        s.sort(Comparator.comparing(SemestreInfo::getSemestreLlevado));
        return s;
    }
}
