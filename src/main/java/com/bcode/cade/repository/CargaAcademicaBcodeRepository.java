package com.bcode.cade.repository;

import com.bcode.cade.entities.CargaAcademicaBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.util.List;

public interface CargaAcademicaBcodeRepository extends JpaRepository<CargaAcademicaBcode, Long> {
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