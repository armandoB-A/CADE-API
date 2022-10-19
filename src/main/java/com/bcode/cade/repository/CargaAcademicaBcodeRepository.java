package com.bcode.cade.repository;

import com.bcode.cade.entities.CargaAcademicaBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CargaAcademicaBcodeRepository extends JpaRepository<CargaAcademicaBcode, Long> {
    @Query("select c from CargaAcademicaBcode c where c.numeroControlFk.id=:numero")
    public List<CargaAcademicaBcode> buscarCargaByNumC(@Param("numero") String numero);
}