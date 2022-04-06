package com.example.project.services;

import com.example.project.entities.EngineType;

import java.util.Optional;

public interface EngineService {

    Iterable<EngineType> listAllEngines();

    Optional<EngineType> getEngineById(int id);

    EngineType saveEngine(EngineType engineType);

    void deleteEngine(int id);

    Boolean checkIfExists(int id);

}
