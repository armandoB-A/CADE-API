package com.bcode.cade.services;

import com.bcode.cade.dto.AlumnoBcodeDto;
import com.bcode.cade.entities.AlumnoBcode;
import com.bcode.cade.repository.AlumnoBcodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoBcodeRepository alumnoBcodeRepository;

    @Autowired
    private ModelMapper modelMapper;
    public List<AlumnoBcodeDto> getAlumnoBcodeRepository() {
        List<AlumnoBcodeDto> list= new ArrayList<>();
        List<AlumnoBcode>al=alumnoBcodeRepository.findAll();
        for (AlumnoBcode a: al) {
            list.add(modelMapper.map(a, AlumnoBcodeDto.class));
        }
        return list;
    }
}
