package com.bcode.cade.repository;

import com.bcode.cade.dto.horarioinfo.*;

import com.bcode.cade.entities.CargaAcademicaBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CargaAcademicaBcodeRepository extends JpaRepository<CargaAcademicaBcode, Long> {


    @Query("select c from CargaAcademicaBcode c where c.numeroControlFk.id = ?1 and c.idHorarioFk.id = ?2")
    CargaAcademicaBcode findByNumeroControlFk_IdAndIdHorarioFk_Id(String id, Long id1);

    @Query("select (count(c) > 0) from CargaAcademicaBcode c where c.numeroControlFk.id = ?1 and c.idHorarioFk.id = ?2")
    boolean existsByNumeroControlFk_IdAndIdHorarioFk_Id(String id, Long id1);
    @Query("select distinct c from CargaAcademicaBcode c where c.numeroControlFk.id = ?1 order by c.semestreLlevado")
    List<SemestreInfo> findDistinctByNumeroControlFk_IdOrderBySemestreLlevadoAsc(String id);

    @Query("select distinct c from CargaAcademicaBcode c where c.numeroControlFk.id = ?1 order by c.semestreLlevado")
    List<SemestresStatusInfo> busquedaSemestres(String id);

    @Query("select c from CargaAcademicaBcode c " +
            "where c.numeroControlFk.id = ?1 and c.semestreLlevado = ?2 " +
            "order by c.idHorarioFk.claveMateriaFk.nombreMateria")
    List<CargaAcademicaSemestreBcodeInfo> findByNumeroControlFk_IdAndSemestreLlevadoOrderByIdHorarioFk_ClaveMateriaFk_NombreMateriaAsc(String id, String semestreLlevado);

    @Query("select c from CargaAcademicaBcode c " +
            "where c.numeroControlFk.id = ?1 and c.semestreLlevado = ?2 " +
            "order by c.idHorarioFk.claveMateriaFk.nombreMateria")
    List<CargaAcademicaBcode> findByNumeroControlFk_IdAndSemestreLlevadoOrderByIdHorarioFk_ClaveMateriaFk_NombreMateriaAsc11(String id, String semestreLlevado);
    @Query("select (count(c) > 0) from CargaAcademicaBcode c where c.numeroControlFk.id = ?1")
    boolean existsByNumeroControlFk_Id(String id);

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

}