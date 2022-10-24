package com.bcode.cade.services;

import com.bcode.cade.dto.Calif;
import com.bcode.cade.dto.CargaAcademicaBcodeDto;
import com.bcode.cade.entities.CargaAcademicaBcode;
import com.bcode.cade.repository.AlumnoBcodeRepository;
import com.bcode.cade.repository.CargaAcademicaBcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class KardexService {
    @Autowired
    private AlumnoBcodeRepository alumnoBcodeRepository;

    @Autowired
    private CargaAcademicaBcodeRepository cargaAcademicaBcodeRepository;

    /*
        public AlumnoBcode getKardex(String numeroControl) {
            try {
                entityToDto(alumnoBcodeRepository.findById(numeroControl).get());
                return alumnoBcodeRepository.findById(numeroControl).get();
            } catch (Exception ex) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El numero de control : " + numeroControl + " no se encuentra registrado", ex);
            }
        }
    */
    public List<CargaAcademicaBcodeDto> getK(String numeroControl) {
        try {
            return entityToDto(cargaAcademicaBcodeRepository.buscarCargaByNumC(numeroControl));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El numero de control : " + numeroControl + " no se encuentra registrado", ex);
        }
    }

    private List<CargaAcademicaBcodeDto> entityToDto(List<CargaAcademicaBcode> cargaAcademicaBcodes) {
        List<CargaAcademicaBcodeDto> listaCargaDef = new ArrayList<>();
        List<Calif> listaCalif = new ArrayList<>();
        for (CargaAcademicaBcode c : cargaAcademicaBcodes) {
            listaCalif.add(new Calif(
                    c.getIdHorarioFk().getClaveMateriaFk().getId(),
                    c.getIdHorarioFk().getClaveMateriaFk().getNombreMateria(),
                    c.getIdHorarioFk().getClaveMateriaFk().getTotalCreditos(),
                    c.getCalificacion(),
                    c.getIdHorarioFk().getPeriodoSemestre(),
                    c.getIdOpcionFk().getDescripcionOpcion(),
                    c.getIdOpcionFk().getOportunidadOpcion()
                    ));
        }
        listaCargaDef.add(new CargaAcademicaBcodeDto(
                cargaAcademicaBcodes.get(0).getNumeroControlFk().getId(), cargaAcademicaBcodes.get(0).getNumeroControlFk().getNombreAlumno(),
                cargaAcademicaBcodes.get(0).getSemestreActual(), listaCalif
        ));
        return listaCargaDef;
    }
}
