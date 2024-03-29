package com.bcode.cade.repository;

import com.bcode.cade.dto.horarioinfo.GruposAdministrativo;
import com.bcode.cade.dto.horarioinfo.GruposInfo;
import com.bcode.cade.dto.horarioinfo.HorarioBcodeInfo;
import com.bcode.cade.entities.HorarioBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioBcodeRepository extends JpaRepository<HorarioBcode, Long> {
    @Query("select (count(h) > 0) from HorarioBcode h where h.claveMateriaFk.id = ?1")
    boolean existsByClaveMateriaFk_Id(String id);
    @Query("select distinct h from HorarioBcode h where h.claveCarreraFk.id = ?1 order by h.idGrupoFk.numeroGrupo")
    List<GruposInfo> findDistinctByClaveCarreraFk_IdOrderByIdGrupoFk_NumeroGrupoAsc(String id);

    @Query("select distinct h from HorarioBcode h where h.claveCarreraFk.id = ?1 order by h.idGrupoFk.numeroGrupo")
    List<com.bcode.cade.dto.HorarioBcodeInfo> findDistinctByClaveCarreraFk_IdOrderByIdGrupoFk_NumeroGrupoAsc1(String id);
    @Query("select h from HorarioBcode h inner join h.idAdministrativoFk.carreraBcodes carreraBcodes " +
            "where carreraBcodes.id = ?1 " +
            "order by h.idGrupoFk.numeroGrupo")
    List<GruposInfo> findByIdAdministrativoFk_CarreraBcodes_IdOrderByIdGrupoFk_NumeroGrupoAsc(String id);
    @Query("select h from HorarioBcode h where h.claveMateriaFk.id = ?1")
    HorarioBcode findByClaveMateriaFk_Id(String id);
    @Query("select h from HorarioBcode h where h.claveCarreraFk.id = ?1 order by h.periodoSemestre")
    List<HorarioBcode> findByClaveCarreraFk_IdOrderByPeriodoSemestreAsc(String id);
    @Query("select h from HorarioBcode h where h.idAdministrativoFk.id = ?1")
    List<HorarioBcode> findByIdAdministrativoFk_Id02(Integer id);
    @Query("select h.claveMateriaFk.id, " +
            "h.claveMateriaFk.nombreMateria, " +
            "h.idGrupoFk.numeroGrupo from HorarioBcode h where h.idAdministrativoFk.id = ?1")
    List<String> findByIdAdministrativoFk_Id(Integer id);

    @Query("select h from HorarioBcode h where h.idAdministrativoFk.id = ?1")
    List<GruposAdministrativo> MateriasByIdAdmin(Integer id);
    @Query("select h.claveMateriaFk.id, " +
            "h.claveMateriaFk.nombreMateria, " +
            "h.idGrupoFk.numeroGrupo from HorarioBcode h where h.idAdministrativoFk.id = ?1")
    List<String> findByIdAdministrativoFk_Id0(Integer id);


    @Query("select h.idGrupoFk.numeroGrupo " +
            "from HorarioBcode h " +
            "where h.claveMateriaFk.id = ?2 and h.idAdministrativoFk.id = ?1")
    List<String> findByGrupoByMateriaFk_Id(Integer id_admin, String clave);

    @Query("select h from HorarioBcode h where h.claveCarreraFk.id = ?1")
    List<HorarioBcodeInfo> findByClaveCarreraFk_Id(String id);




    @Query("select h.idGrupoFk.numeroGrupo " +
            "from HorarioBcode h " +
            "where h.claveMateriaFk.id = ?2 and h.idAdministrativoFk.id = ?1")
    List<String> findByGrupoByMateriaFk_Id01(Integer id_admin, String clave);
}