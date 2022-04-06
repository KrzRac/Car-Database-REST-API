package com.example.project.services;

import com.example.project.entities.Model;

import java.util.List;
import java.util.Optional;

public interface ModelService {

    Iterable<Model> listAllModels();

    Optional<Model> getModelById(int id);

    Model saveModel(Model model);

    void deleteModel(int id);

    Boolean checkIfExists(int id);

    Iterable<Model> listOfAllModelPaging(int pageNr, int howManyOnPage);

    List<Model> findModelsByImplementationYearBefore(int implementationYear);
}
