package com.bcode.cade.repository;

import com.bcode.cade.entities.CarreraBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
public interface CarreraBcodeRepository extends JpaRepository<CarreraBcode, String> {
    List<CarreraBcode> findAllByStatusCarrera(Character statusCarrera);
}