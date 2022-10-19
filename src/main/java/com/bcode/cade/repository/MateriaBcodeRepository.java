package com.bcode.cade.repository;

import com.bcode.cade.entities.MateriaBcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface MateriaBcodeRepository extends JpaRepository<MateriaBcode, String> {
}