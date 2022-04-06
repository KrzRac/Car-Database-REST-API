package com.example.project.services;

import com.example.project.entities.EngineType;
import com.example.project.repositories.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EngineServiceImpl implements EngineService {

    @Autowired
    private EngineRepository engineRepository;

    @Override
    public Iterable<EngineType> listAllEngines() {
        return engineRepository.findAll();
    }

    @Override
    public Optional<EngineType> getEngineById(int id) {
        return engineRepository.findById(id);
    }

    @Override
    public EngineType saveEngine(EngineType engineType) {
        return engineRepository.save(engineType);
    }

    @Override
    public void deleteEngine(int id) {
        engineRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(int id) {
        return engineRepository.checkIfExist(id) > 0;
    }

}
