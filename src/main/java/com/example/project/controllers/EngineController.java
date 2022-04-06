package com.example.project.controllers;

import com.example.project.repositories.EngineRepository;
import com.example.project.services.EngineService;
import com.example.project.entities.EngineType;
import com.example.project.entities.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EngineController {

    @Autowired
    private EngineService engineService;

    @Autowired
    private EngineRepository engineRepository;

    @GetMapping(value = "/engines", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EngineType> list(Model model) {
        return engineService.listAllEngines();
    }

    @GetMapping(value = "/engine/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EngineType getById(@PathVariable("id") int id) {
        if (engineService.checkIfExists(id).equals(true)) {
            return engineService.getEngineById(id).orElseGet(null);
        } else {
            return null;
        }
    }

    @PostMapping(value = "/engine")
    public ResponseEntity<EngineType> create(@RequestBody EngineType engineType) {
        if(!engineService.checkIfExists(engineType.getId())) {
            engineService.saveEngine(engineType);
            return ResponseEntity.ok().body(engineType);
        } else {
            engineService.saveEngine(engineType);
            return ResponseEntity.ok().build();
        }
    }


    @PutMapping(value = "/engine")
    public ResponseEntity<Void> edit(@RequestBody EngineType engineType) {
        if(!engineService.checkIfExists(engineType.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            engineService.saveEngine(engineType);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/engine/{id}")
    public ResponseEntity<EngineType> delete(@PathVariable int id) {
        engineService.deleteEngine(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
