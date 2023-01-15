package com.bcode.cade.repository;

import com.bcode.cade.entities.DetalleAdministrativoBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetalleAdministrativoBcodeRepository extends JpaRepository<DetalleAdministrativoBcode, Integer> {
    @Query("select (count(d) > 0) from DetalleAdministrativoBcode d " +
            "where d.idAdministrativoFk.id = ?1 and d.claveCarreraFk.id = ?2")
    boolean existsByIdAdministrativoFk_IdAndClaveCarreraFk_Id(Integer id, String id1);

}