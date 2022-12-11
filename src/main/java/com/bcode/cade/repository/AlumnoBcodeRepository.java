package com.bcode.cade.repository;

import com.bcode.cade.dto.AlumnoBcodeDto;
import com.bcode.cade.entities.AlumnoBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoBcodeRepository extends JpaRepository<AlumnoBcode, String> {
    AlumnoBcode findByIdAndAndClaveCarreraFk_DescripcionCarrera(String id, String DescripcionCarrera);
    Long countAlumnoBcodeByClaveCarreraFkDescripcionCarrera(String DescripcionCarrera);

    @Query("select a from AlumnoBcode a where a.id = ?1 and a.contraseniaAlumno = ?2")
    AlumnoBcode findByIdAndContraseniaAlumno(String id, String contraseniaAlumno);

}