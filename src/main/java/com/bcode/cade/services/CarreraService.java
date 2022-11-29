package com.bcode.cade.services;

import com.bcode.cade.dto.CarreraBcodeDto;
import com.bcode.cade.entities.CarreraBcode;
import com.bcode.cade.repository.CarreraBcodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarreraService {
    @Autowired
    private CarreraBcodeRepository carreraBcodeRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<CarreraBcodeDto> getCarreraBcodeRepository() {
        List<CarreraBcodeDto> list= new ArrayList<>();
        List<CarreraBcode>cr=carreraBcodeRepository.findAllByStatusCarrera('1');
        cr.forEach(carreraBcode -> list.add(modelMapper.map(carreraBcode, CarreraBcodeDto.class)));
        return list;
    }
}
