package com.bcode.cade.repository;

import com.bcode.cade.entities.AlumnoBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoBcodeRepository extends JpaRepository<AlumnoBcode, String> {

}