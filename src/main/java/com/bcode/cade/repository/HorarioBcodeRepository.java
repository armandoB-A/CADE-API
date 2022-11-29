package com.bcode.cade.repository;

import com.bcode.cade.entities.HorarioBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioBcodeRepository extends JpaRepository<HorarioBcode, Long> {
    @Query("select h from HorarioBcode h where h.idAdministrativoFk.id = ?1")
    List<HorarioBcode> findByIdAdministrativoFk_Id(Integer id);

}