package com.bcode.cade.services;

import com.bcode.cade.dto.AdministrativoAuth;
import com.bcode.cade.entities.AdministrativoBcode;
import com.bcode.cade.entities.HorarioBcode;
import com.bcode.cade.repository.AdministrativoBcodeRepository;
import com.bcode.cade.repository.DetalleAdministrativoBcodeRepository;
import com.bcode.cade.repository.HorarioBcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AdministrativoService {
    @Autowired
    private AdministrativoBcodeRepository administrativoBcodeRepository;
    @Autowired
    private DetalleAdministrativoBcodeRepository detalleAdministrativoBcodeRepository;
    @Autowired
    private HorarioBcodeRepository horarioBcodeRepository;

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

    public AdministrativoBcode authuAdmin(AdministrativoAuth admin) {

        AdministrativoBcode ad = administrativoBcodeRepository.findByNombreAdministrativoAndContraseniaAdministrativo(admin.getNombreAdministrativo(), admin.getContraseniaAdministrativo());
        if (ad == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no se encontro administrativo ");
        } else {
            return ad;
        }
    }

    public List<HorarioBcode> getAdministrativoMaterias(Integer id) {
        return horarioBcodeRepository.findByIdAdministrativoFk_Id(id);
    }
}
