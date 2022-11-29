package com.bcode.cade.repository;

import com.bcode.cade.entities.AdministrativoBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministrativoBcodeRepository extends JpaRepository<AdministrativoBcode, Integer> {
    @Query("select a from AdministrativoBcode a inner join a.carreraBcodes carreraBcodes " +
            "where carreraBcodes.descripcionCarrera = ?1")
    List<AdministrativoBcode> findByCarreraBcodes_DescripcionCarrera(String descripcionCarrera);
}