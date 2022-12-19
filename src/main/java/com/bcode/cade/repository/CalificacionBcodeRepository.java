package com.bcode.cade.repository;

import com.bcode.cade.entities.CalificacionBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
@Repository
public interface CalificacionBcodeRepository extends JpaRepository<CalificacionBcode, Long> {
    @Query("select c from CalificacionBcode c where c.idCargaAcademicaFk.idHorarioFk.id = ?1")
    CalificacionBcode findByIdCargaAcademicaFk_IdHorarioFk_Id(Long id);

    @Query("select " +
            "c.idCargaAcademicaFk.idHorarioFk.claveCarreraFk.descripcionCarrera as carrera," +
            "c.idCargaAcademicaFk.semestreLlevado as semestre," +
            "c.idCargaAcademicaFk.idHorarioFk.claveMateriaFk.id as clavecrr," +
            "c.idCargaAcademicaFk.idHorarioFk.claveMateriaFk.nombreMateria as materia," +
            "c.idCargaAcademicaFk.idHorarioFk.idGrupoFk.numeroGrupo as grupo," +
            "c.idCargaAcademicaFk.idHorarioFk.claveMateriaFk.totalCreditos as totalc," +
            "c.calificacion as calificacion, c.nivelDesempenio as niveld," +
            "c.idCargaAcademicaFk.idOpcionFk.descripcionOpcion as op," +
            "c.idCargaAcademicaFk.idOpcionFk.oportunidadOpcion as opd " +
            "from CalificacionBcode c where c.idCargaAcademicaFk.numeroControlFk.id=:numero")
    List<Tuple> buscarCargaByNumC(@Param("numero") String numero);

    @Query("select " +
            "c.idCargaAcademicaFk.idHorarioFk.claveCarreraFk.descripcionCarrera as carrera," +
            "c.idCargaAcademicaFk.semestreLlevado as semestre," +
            "c.idCargaAcademicaFk.idHorarioFk.claveMateriaFk.id as clavecrr," +
            "c.idCargaAcademicaFk.idHorarioFk.claveMateriaFk.nombreMateria as materia," +
            "c.idCargaAcademicaFk.idHorarioFk.idGrupoFk.numeroGrupo as grupo," +
            "c.idCargaAcademicaFk.idHorarioFk.claveMateriaFk.totalCreditos as totalc," +
            "c.calificacion as calificacion, c.nivelDesempenio as niveld," +
            "c.idCargaAcademicaFk.idOpcionFk.descripcionOpcion as op," +
            "c.idCargaAcademicaFk.idOpcionFk.oportunidadOpcion as opd " +
            "from CalificacionBcode c " +
            "where c.idCargaAcademicaFk.numeroControlFk.id=:numero " +
            "and c.idCargaAcademicaFk.semestreLlevado=:semestre")
    List<Tuple> buscarCargaByNumCAndSemestre(@Param("numero") String numero, @Param("semestre") String semestre);

    @Query("select h.id, " +
            "h.idCargaAcademicaFk.numeroControlFk.id, " +
            "h.idCargaAcademicaFk.numeroControlFk.nombreAlumno, " +
            "h.idCargaAcademicaFk.idHorarioFk.claveMateriaFk.nombreMateria, " +
            "h.idCargaAcademicaFk.idHorarioFk.idGrupoFk.numeroGrupo, " +
            "h.idCargaAcademicaFk.idOpcionFk.descripcionOpcion, " +
            "h.calificacion " +
            "from CalificacionBcode h " +
            "where h.statusCalificacion = '1'")
    List<String> findSomeFields();

    @Query("select h.id, " +
            "h.idCargaAcademicaFk.numeroControlFk.id, " +
            "h.idCargaAcademicaFk.numeroControlFk.nombreAlumno, " +
            "h.idCargaAcademicaFk.idHorarioFk.claveMateriaFk.nombreMateria, " +
            "h.idCargaAcademicaFk.idHorarioFk.idGrupoFk.numeroGrupo, " +
            "h.idCargaAcademicaFk.idOpcionFk.descripcionOpcion, " +
            "h.calificacion " +
            "from CalificacionBcode h " +
            "where h.statusCalificacion = '0'")
    List<String> findEmptyFields();
}