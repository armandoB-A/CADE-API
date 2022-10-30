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
}