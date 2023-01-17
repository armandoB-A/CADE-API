package com.bcode.cade.repository;

import com.bcode.cade.entities.AdministrativoBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministrativoBcodeRepository extends JpaRepository<AdministrativoBcode, Integer> {
    @Query("select a from AdministrativoBcode a where a.idRolFk.id = ?1")
    List<AdministrativoBcode> findByIdRolFk_Id(Byte id);
    @Query("select a from AdministrativoBcode a where a.nombreAdministrativo = ?1 and a.contraseniaAdministrativo = ?2")
    AdministrativoBcode findByNombreAdministrativoAndContraseniaAdministrativo(String nombreAdministrativo, String contraseniaAdministrativo);
    @Query("select a from AdministrativoBcode a inner join a.carreraBcodes carreraBcodes " +
            "where carreraBcodes.descripcionCarrera = ?1")
    List<AdministrativoBcode> findByCarreraBcodes_DescripcionCarrera(String descripcionCarrera);

    @Query("select a from AdministrativoBcode a where a.idRolFk.id = ?1 and a.carreraBcodes is empty")
    List<AdministrativoBcode> findByIdRolFk_IdAndCarreraBcodesEmpty(Byte id);


}