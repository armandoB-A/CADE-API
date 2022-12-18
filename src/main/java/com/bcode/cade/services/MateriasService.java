package com.bcode.cade.services;

import com.bcode.cade.dto.HorarioBcodeDto;
import com.bcode.cade.entities.HorarioBcode;
import com.bcode.cade.repository.HorarioBcodeRepository;
import com.bcode.cade.repository.MateriaBcodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MateriasService {
    @Autowired
    private MateriaBcodeRepository materiaBcodeRepository;
    @Autowired
    private HorarioBcodeRepository horarioBcodeRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<HorarioBcodeDto> getMateriasByCarrera(String carrera) {
        List<HorarioBcodeDto> listD = new ArrayList<>();
        horarioBcodeRepository
                .findByClaveCarreraFk_IdOrderByPeriodoSemestreAsc(carrera)
                .forEach(horarioBcode -> listD.add(modelMapper.map(horarioBcode, HorarioBcodeDto.class)));

        return listD;
    }
}
