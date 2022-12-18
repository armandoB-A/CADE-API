package com.bcode.cade.repository;

import com.bcode.cade.dto.HorarioBcodeDto;
import com.bcode.cade.dto.horarioinfo.HorarioBcodeInfo;
import com.bcode.cade.entities.HorarioBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioBcodeRepository extends JpaRepository<HorarioBcode, Long> {
    @Query("select h from HorarioBcode h where h.claveCarreraFk.id = ?1 order by h.periodoSemestre")
    List<HorarioBcode> findByClaveCarreraFk_IdOrderByPeriodoSemestreAsc(String id);
    @Query("select h from HorarioBcode h where h.idAdministrativoFk.id = ?1")
    List<HorarioBcode> findByIdAdministrativoFk_Id(Integer id);

    @Query("select h.claveMateriaFk, h.idGrupoFk, h.periodoSemestre from HorarioBcode h where h.claveCarreraFk.id = ?1")
    List<HorarioBcodeDto> findByClaveCarreraFk_Id2(String id);

    @Query("select h from HorarioBcode h where h.claveCarreraFk.id = ?1")
    List<HorarioBcodeInfo> findByClaveCarreraFk_Id(String id);



}