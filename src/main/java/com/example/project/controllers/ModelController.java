package com.example.project.controllers;

import com.example.project.repositories.ModelRepository;
import com.example.project.services.ModelService;
import com.example.project.entities.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ModelController {


    @Autowired
    private ModelService modelService;

    @Autowired
    private ModelRepository modelRepository;


    @GetMapping(value = "/models", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Model> list(Model model) {
        return modelService.listAllModels();
    }


    @GetMapping(value = "/model/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Model getById(@PathVariable("id") int id) {
        if (modelService.checkIfExists(id).equals(true)) {
            return modelService.getModelById(id).orElseGet(null);
        } else {
            return null;
        }
    }

    @GetMapping(value = "/models/before{implementationYear}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Model> getBeforeYear(@PathVariable("implementationYear") int implementationYear) {
        return modelService.findModelsByImplementationYearBefore(implementationYear);
    }

    @GetMapping(value = "/models/before", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Model> getByParamPublicId(@RequestParam("implementationYear") int implementationYear) {
        return modelService.findModelsByImplementationYearBefore(implementationYear);
    }


    @PostMapping(value = "/model")
    public Optional<Model> create(@RequestBody Model model) {
        modelService.saveModel(model);

        return modelRepository.findById(model.getId());
    }

    @PutMapping(value = "/model")
    @ResponseStatus
    public ResponseEntity<Void> edit(@RequestBody Model model) {
        if(!modelService.checkIfExists(model.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            modelService.saveModel(model);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/model/{id}")
    public ResponseEntity<Model> delete(@PathVariable int id) {
        modelService.deleteModel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/models/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Model> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return modelService.listOfAllModelPaging(pageNr, howManyOnPage.orElse(2));
    }

}
