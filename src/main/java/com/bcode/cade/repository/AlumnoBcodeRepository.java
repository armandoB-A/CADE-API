package com.bcode.cade.repository;

import com.bcode.cade.entities.AlumnoBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoBcodeRepository extends JpaRepository<AlumnoBcode, String> {
    AlumnoBcode findByIdAndAndClaveCarreraFk_DescripcionCarrera(String id, String DescripcionCarrera);
    Long countAlumnoBcodeByClaveCarreraFkDescripcionCarrera(String DescripcionCarrera);
}