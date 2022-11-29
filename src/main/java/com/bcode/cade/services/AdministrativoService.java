package com.bcode.cade.services;

import com.bcode.cade.entities.AdministrativoBcode;
import com.bcode.cade.repository.AdministrativoBcodeRepository;
import com.bcode.cade.repository.DetalleAdministrativoBcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrativoService {
    @Autowired
    private AdministrativoBcodeRepository administrativoBcodeRepository;
    @Autowired
    private DetalleAdministrativoBcodeRepository detalleAdministrativoBcodeRepository;
    /*
    public AdministrativoBcode getAdministrativoBcodeRepository() {
        return administrativoBcodeRepository.findById(id).get();
    }
    */
    public AdministrativoBcode getAdministrativo(Integer id) {
        return administrativoBcodeRepository.findById(id).get();
    }
    public List<AdministrativoBcode> getAdministrativos() {
        return administrativoBcodeRepository.findAll();
    }

    public List<AdministrativoBcode> getDocenteByCarrera(String carrera) {
        return administrativoBcodeRepository.findByCarreraBcodes_DescripcionCarrera(carrera);
    }
}
