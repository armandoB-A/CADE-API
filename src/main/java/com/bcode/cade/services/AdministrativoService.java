package com.bcode.cade.services;

import com.bcode.cade.dto.AdministrativoAuth;
import com.bcode.cade.dto.horarioinfo.AlumnosByMaterias;
import com.bcode.cade.dto.horarioinfo.GruposAdministrativo;
import com.bcode.cade.entities.AdministrativoBcode;
import com.bcode.cade.entities.HorarioBcode;
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
    public List<GruposAdministrativo> getMateriasByIdAdmin(Integer id_admin) {
        return horarioBcodeRepository.MateriasByIdAdmin(id_admin);
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
    public List<AlumnosByMaterias> getLisAlum(Integer idAdmin, String claveMateria, String grupo) {
        List<AlumnosByMaterias> ad = cargaAcademicaBcodeRepository.findByIdHorarioFk_IdAdministrativoFk_IdAndIdHorarioFk_ClaveMateriaFk_IdAndIdHorarioFk_IdGrupoFk_NumeroGrupoOrderByNumeroControlFk_NombreAlumnoAsc(idAdmin, claveMateria, grupo);
        if (ad == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se Encontrarion Alumnos ");
        }else{
            return ad;
        }
    }
}
