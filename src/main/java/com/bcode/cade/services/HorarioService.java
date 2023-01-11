package com.bcode.cade.services;

import com.bcode.cade.dto.horarioinfo.GruposInfo;
import com.bcode.cade.repository.HorarioBcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {
    @Autowired
    private HorarioBcodeRepository horarioBcodeRepository;

    public List<GruposInfo> getGrupos(String carrera) {
        return horarioBcodeRepository.findByIdAdministrativoFk_CarreraBcodes_IdOrderByIdGrupoFk_NumeroGrupoAsc(carrera);
    }
}
