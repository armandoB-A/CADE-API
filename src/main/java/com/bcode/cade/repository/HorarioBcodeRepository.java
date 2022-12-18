package com.bcode.cade.repository;

import com.bcode.cade.entities.HorarioBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioBcodeRepository extends JpaRepository<HorarioBcode, Long> {
    @Query("select h.claveMateriaFk.id, " +
            "h.claveMateriaFk.nombreMateria, " +
            "h.idGrupoFk.numeroGrupo from HorarioBcode h where h.idAdministrativoFk.id = ?1")
    List<String> findByIdAdministrativoFk_Id(Integer id);


    @Query("select h.idGrupoFk.numeroGrupo " +
            "from HorarioBcode h " +
            "where h.claveMateriaFk.id = ?2 and h.idAdministrativoFk.id = ?1")
    List<String> findByGrupoByMateriaFk_Id(Integer id_admin, String clave);
}