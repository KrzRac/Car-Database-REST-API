package com.example.project.repositories;

import com.example.project.entities.EngineType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EngineRepository extends CrudRepository<EngineType, Integer> {

    @Query("select e FROM EngineType e WHERE e.id=?1")
    Optional<EngineType> findById(int id);

    @Query("SELECT COUNT(m) from Model m where m.id = ?1")
    Integer checkIfExist(Integer id);

}
