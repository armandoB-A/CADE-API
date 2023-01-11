package com.bcode.cade.services;

import com.bcode.cade.dto.horarioinfo.GruposInfo;
import com.bcode.cade.dto.horarioinfo.CargaAcademicaBcodeInfo;
import com.bcode.cade.repository.CargaAcademicaBcodeRepository;
import com.bcode.cade.repository.HorarioBcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HorarioService {
    @Autowired
    private HorarioBcodeRepository horarioBcodeRepository;
    @Autowired
    private CargaAcademicaBcodeRepository cargaAcademicaBcodeRepository;

    public List<GruposInfo> getGrupos(String carrera) {
        ArrayList<GruposInfo> s= new ArrayList<>(horarioBcodeRepository.findDistinctByClaveCarreraFk_IdOrderByIdGrupoFk_NumeroGrupoAsc(carrera).stream()
                .collect(Collectors.toMap(e -> e.getIdGrupoFk().getNumeroGrupo(), e -> e, (v1, v2) -> v1))
                .values());
        s.sort(Comparator.comparing(a -> a.getIdGrupoFk().getNumeroGrupo()));
        return s;
    }

    public List<CargaAcademicaBcodeInfo> getAlumn(String grupo) {
        return cargaAcademicaBcodeRepository.findByIdHorarioFk_IdGrupoFk_NumeroGrupoOrderByNumeroControlFk_Ape1AlumnoAsc(grupo);
    }
}
