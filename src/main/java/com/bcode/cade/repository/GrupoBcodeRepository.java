package com.bcode.cade.repository;

import com.bcode.cade.entities.GrupoBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoBcodeRepository extends JpaRepository<GrupoBcode, Integer> {
}