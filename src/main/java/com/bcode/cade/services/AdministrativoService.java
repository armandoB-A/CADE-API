package com.bcode.cade.services;

import com.bcode.cade.dto.AdministrativoAuth;
import com.bcode.cade.dto.CalificacionSaveBcodeDto;
import com.bcode.cade.entities.AdministrativoBcode;
import com.bcode.cade.entities.CalificacionBcode;
import com.bcode.cade.repository.*;
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
    @Autowired
    private CargaAcademicaBcodeRepository cargaAcademicaBcodeRepository;
    @Autowired
    private CalificacionBcodeRepository calificacionBcodeRepository;

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

    public List<String> getAdministrativoMaterias(Integer id) {
        return horarioBcodeRepository.findByIdAdministrativoFk_Id(id);
    }

    public AdministrativoBcode authuAdmin(String nom, String contra) {
        AdministrativoBcode ad = administrativoBcodeRepository.findByNombreAdministrativoAndContraseniaAdministrativo(nom, contra);
        if (ad == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no se encontro administrativo ");
        } else {
            return ad;
        }
    }

    public List<String> getAdministrativoGrupos(Integer id_admin, String clave) {
        return horarioBcodeRepository.findByGrupoByMateriaFk_Id(id_admin, clave);
    }

    public List<String> getAdministrativoAlumnoGrupo(Integer idAdmin, String claveMateria, String grupo) {
        List<String> ad = cargaAcademicaBcodeRepository.findAlumnosByGrupo(idAdmin, claveMateria, grupo);
        if (ad == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se Encontrarion Alumnos ");
        }else{
            return ad;
        }
    }

    public CalificacionBcode registrarCalificacion(CalificacionBcode calificacionSaveBcode) {
        return calificacionBcodeRepository.save(calificacionSaveBcode);
        /*CalificacionBcode calificacionBcode = new CalificacionBcode();
        CalificacionBcode calificacionBcodeOR = new CalificacionBcode();
        calificacionBcodeOR = getCalificacion(calificacionBcodeRepository.saveAndFlush(dtoToEntity(calificacionSaveBcodeDto, calificacionBcode)));
        return*/
    }

    /*private CalificacionBcode dtoToEntity(CalificacionSaveBcodeDto calificacionSaveBcodeDto, CalificacionBcode calificacionBcode) {
        calificacionBcode.setId(calificacionSaveBcodeDto.getId());
        return getCalificacionBcode(calificacionSaveBcodeDto, calificacionBcode);
    }*/

    /*private CalificacionBcode getCalificacionBcode(CalificacionSaveBcodeDto calificacionSaveBcodeDto, CalificacionBcode calificacionBcode) {
        try {
            if (calificacionSaveBcodeDto.getIdCargaAcademicaFk() == null) {
                calificacionBcode.setIdCargaAcademicaFk(cargaAcademicaBcodeRepository.findById(calificacionSaveBcodeDto.getIdCargaAcademicaFk()).get());
            }
        }catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error en el id de la carga academica, no existe o esta mal escrita", ex);
        }

        if(calificacionSaveBcodeDto.getCalificacion() != null)
            calificacionBcode.setCalificacion(calificacionSaveBcodeDto.getCalificacion());

        if(calificacionSaveBcodeDto.getNivelDesempenio() != null)
            calificacionBcode.setNivelDesempenio(calificacionSaveBcodeDto.getNivelDesempenio());

        calificacionBcode.setStatusCalificacion('1');
        return calificacionBcode;
    }*/

    /*private CalificacionBcode getCalificacion(CalificacionBcode calificacionBcode) {
        return calificacionBcodeRepository.findByAll(calificacionBcode.getCalificacion(),
                calificacionBcode.getNivelDesempenio())
    }*/
}
