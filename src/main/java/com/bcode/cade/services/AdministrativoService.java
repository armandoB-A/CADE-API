package com.bcode.cade.services;

import com.bcode.cade.dto.*;
import com.bcode.cade.dto.horarioinfo.AlumnosByMaterias;
import com.bcode.cade.dto.horarioinfo.GruposAdministrativo;
import com.bcode.cade.entities.AdministrativoBcode;
import com.bcode.cade.entities.CalificacionBcode;
import com.bcode.cade.entities.CarreraBcode;
import com.bcode.cade.entities.HorarioBcode;
import com.bcode.cade.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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
    @Autowired
    private RolBcodeRepository rolBcodeRepository;
    @Autowired
    private CarreraBcodeRepository carreraBcodeRepository;

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
        if (ad == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se Encontrarion Alumnos ");
        } else {
            return ad;
        }
    }

    public List<AlumnosByMaterias> getLisAlum(Integer idAdmin, String claveMateria, String grupo) {
        List<AlumnosByMaterias> ad = cargaAcademicaBcodeRepository.findByIdHorarioFk_IdAdministrativoFk_IdAndIdHorarioFk_ClaveMateriaFk_IdAndIdHorarioFk_IdGrupoFk_NumeroGrupoOrderByNumeroControlFk_NombreAlumnoAsc(idAdmin, claveMateria, grupo);
        if (ad == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se Encontrarion Alumnos ");
        } else {
            return ad;
        }
    }

    public List<CalificacionBcode> calificacion(List<CalificacionAlumnosBcodeDto> calificaciones) {
        List<CalificacionBcode> cs = new ArrayList<>();
        cs = obtenerClaif(calificaciones);
        cs.forEach(s -> {
            System.out.println(s.getId() + "#" + s.getCalificacion());
        });
        return calificacionBcodeRepository.saveAll(cs);
    }

    public List<CalificacionBcode> obtenerClaif(List<CalificacionAlumnosBcodeDto> calif) {
        List<CalificacionBcode> califObjFinal = new ArrayList<>();

        calif.forEach(ob -> {
            CalificacionBcode c = new CalificacionBcode();
            c.setIdCargaAcademicaFk(cargaAcademicaBcodeRepository.findById(ob.getIdCargaAcademicaFkId()).get());
            c.setCalificacion(ob.getCalificacion());
            c.setNivelDesempenio(ob.getNivelDesempenio());
            c.setStatusCalificacion(ob.getStatusCalificacion());
            califObjFinal.add(c);
        });
        return califObjFinal;
    }

    public AdministrativoSaveBcodeDto actualizarDocente(AdministrativoSaveBcodeDto administrativoSaveBcodeDto, Integer id) {
        AdministrativoBcode administrativoBcode = null;
        if (!adminExist(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro Docente");
        }
        administrativoBcode = administrativoBcodeRepository.findById(id).get();
        try {
            AdministrativoBcode docente = dtoToEntity(administrativoSaveBcodeDto, administrativoBcode, id);
            AdministrativoBcode docenteBcode1 = administrativoBcodeRepository.saveAndFlush(docente);
            return entityToDto(docenteBcode1);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error saving");
        }
    }

    public boolean adminExist(Integer id) {
        if (administrativoBcodeRepository.existsById(id)) {
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Administrativo No Encontrado");
        }
    }

    private AdministrativoBcode dtoToEntity(AdministrativoSaveBcodeDto administrativoSaveBcodeDto, AdministrativoBcode administrativoBcode, Integer id){
        administrativoBcode.setId(id);
        return getAdministrativoBcode(administrativoSaveBcodeDto, administrativoBcode);
    }

    private AdministrativoBcode getAdministrativoBcode(AdministrativoSaveBcodeDto administrativoSaveBcodeDto, AdministrativoBcode administrativoBcode){
        if(administrativoSaveBcodeDto.getNombreAdministrativo() != null)
            administrativoBcode.setNombreAdministrativo(administrativoSaveBcodeDto.getNombreAdministrativo());

        if(administrativoSaveBcodeDto.getApe1Administrativo() != null)
            administrativoBcode.setApe1Administrativo(administrativoSaveBcodeDto.getApe1Administrativo());

        if(administrativoSaveBcodeDto.getApe2Administrativo() != null)
            administrativoBcode.setApe2Administrativo(administrativoSaveBcodeDto.getApe2Administrativo());

        if(administrativoSaveBcodeDto.getTelefonoAdministrativo() != null)
            administrativoBcode.setTelefonoAdministrativo(administrativoSaveBcodeDto.getTelefonoAdministrativo());

        if(administrativoSaveBcodeDto.getCorreoAdministrativo() != null)
            administrativoBcode.setCorreoAdministrativo(administrativoSaveBcodeDto.getCorreoAdministrativo());

        if(administrativoSaveBcodeDto.getDireccionAdministrativo() != null)
            administrativoBcode.setDireccionAdministrativo(administrativoSaveBcodeDto.getDireccionAdministrativo());

        if(administrativoSaveBcodeDto.getContraseniaAdministrativo() != null)
            administrativoBcode.setContraseniaAdministrativo(administrativoSaveBcodeDto.getContraseniaAdministrativo());

        if(administrativoSaveBcodeDto.getStatusAdministrativo() != null)
            administrativoBcode.setStatusAdministrativo(administrativoSaveBcodeDto.getStatusAdministrativo());

        return administrativoBcode;
    }

    private AdministrativoSaveBcodeDto entityToDto(AdministrativoBcode docente){
        return new AdministrativoSaveBcodeDto(
                docente.getId(),
                docente.getNombreAdministrativo(),
                docente.getApe1Administrativo(),
                docente.getApe2Administrativo(),
                docente.getTelefonoAdministrativo(),
                docente.getCorreoAdministrativo(),
                docente.getDireccionAdministrativo(),
                docente.getStatusAdministrativo(),
                docente.getContraseniaAdministrativo(),
                docente.getIdRolFkId().getId()
        );
    }

    public AdministrativoBcode registrarAlumno(AdministrativoSaveBcodeDto administrativoBcode) {
        AdministrativoBcode administrativo = dtoToEntity(administrativoBcode);
        AdministrativoBcode adm = administrativoBcodeRepository.saveAndFlush(administrativo);
        return adm;
    }
    private AdministrativoBcode dtoToEntity(AdministrativoSaveBcodeDto administrativoSaveBcodeDto){
        AdministrativoBcode administrativoBcode = new AdministrativoBcode();
        administrativoBcode.setNombreAdministrativo(administrativoSaveBcodeDto.getNombreAdministrativo());
        administrativoBcode.setApe1Administrativo(administrativoSaveBcodeDto.getApe1Administrativo());
        administrativoBcode.setApe2Administrativo(administrativoSaveBcodeDto.getApe2Administrativo());
        administrativoBcode.setTelefonoAdministrativo(administrativoSaveBcodeDto.getTelefonoAdministrativo());
        administrativoBcode.setCorreoAdministrativo(administrativoSaveBcodeDto.getCorreoAdministrativo());
        administrativoBcode.setDireccionAdministrativo(administrativoSaveBcodeDto.getDireccionAdministrativo());
        administrativoBcode.setStatusAdministrativo(administrativoSaveBcodeDto.getStatusAdministrativo());
        administrativoBcode.setContraseniaAdministrativo(administrativoSaveBcodeDto.getContraseniaAdministrativo());
        administrativoBcode.setIdRolFk(rolBcodeRepository.findById(administrativoSaveBcodeDto.getIdRolFkId()).get());
        return administrativoBcode;
    }
}
