package com.bcode.cade.repository;

import com.bcode.cade.dto.horarioinfo.CargaAcademicaSemestreBcodeInfo;
import com.bcode.cade.dto.horarioinfo.AlumnosByMaterias;
import com.bcode.cade.dto.horarioinfo.CargaAcademicaBcodeInfo;

import com.bcode.cade.entities.CargaAcademicaBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CargaAcademicaBcodeRepository extends JpaRepository<CargaAcademicaBcode, Long> {
    @Query("select c from CargaAcademicaBcode c " +
            "where c.numeroControlFk.id = ?1 and c.semestreLlevado = ?2 " +
            "order by c.idHorarioFk.claveMateriaFk.nombreMateria")
    List<CargaAcademicaSemestreBcodeInfo> findByNumeroControlFk_IdAndSemestreLlevadoOrderByIdHorarioFk_ClaveMateriaFk_NombreMateriaAsc(String id, String semestreLlevado);

    boolean existsByNumeroControlFk_IdAndNumeroControlFk_StatusAlumno(String id, Character statusAlumno);

    @Query("select h.numeroControlFk.nombreAlumno from CargaAcademicaBcode h " +
            "where h.idHorarioFk.idAdministrativoFk.id = ?1 " +
            "and h.idHorarioFk.claveMateriaFk.id = ?2 " +
            "and h.idHorarioFk.idGrupoFk.numeroGrupo = ?3")
    List<String> findAlumnosByGrupo(Integer idAdmin, String claveMateria, String grupo);

    @Query("select c from CargaAcademicaBcode c " +
            "where c.idHorarioFk.idAdministrativoFk.id = ?1 and c.idHorarioFk.claveMateriaFk.id = ?2 and c.idHorarioFk.idGrupoFk.numeroGrupo = ?3 " +
            "order by c.numeroControlFk.nombreAlumno")
    List<AlumnosByMaterias> findByIdHorarioFk_IdAdministrativoFk_IdAndIdHorarioFk_ClaveMateriaFk_IdAndIdHorarioFk_IdGrupoFk_NumeroGrupoOrderByNumeroControlFk_NombreAlumnoAsc(Integer id, String id1, String numeroGrupo);

    @Query("select c from CargaAcademicaBcode c " +
            "where c.idHorarioFk.idGrupoFk.numeroGrupo = ?1 " +
            "order by c.numeroControlFk.ape1Alumno")
    List<CargaAcademicaBcodeInfo> findByIdHorarioFk_IdGrupoFk_NumeroGrupoOrderByNumeroControlFk_Ape1AlumnoAsc(String numeroGrupo);
    
    
    /*@Query("select " +
            "c.idHorarioFk.claveCarreraFk.descripcionCarrera as carrera," +
            "c.semestreLlevado as semestre," +
            "c.idHorarioFk.claveMateriaFk.id as clavecrr," +
            "c.idHorarioFk.claveMateriaFk.nombreMateria as materia," +
            "c.idHorarioFk.claveMateriaFk.totalCreditos as totalc," +
            "c. " +
            "from CargaAcademicaBcode c where c.numeroControlFk.id=:numero")
    public List<Tuple> buscarCargaByNumC(@Param("numero") String numero);*/
}