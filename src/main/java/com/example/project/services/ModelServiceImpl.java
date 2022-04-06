package com.example.project.services;

import com.example.project.entities.Model;
import com.example.project.repositories.ModelRepository;
import com.example.project.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public Iterable<Model> listAllModels() {
        return modelRepository.findAll();
    }

    @Override
    public Optional<Model> getModelById(int id) {
        return modelRepository.findById(id);
    }

    @Override
    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public void deleteModel(int id) {
        modelRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(int id) {
        return modelRepository.checkIfExist(id) > 0;
    }

    @Override
    public Iterable<Model> listOfAllModelPaging(int pageNr, int howManyOnPage) {
        return modelRepository.findAll(PageRequest.of(pageNr, howManyOnPage));
    }

    @Override
    public List<Model> findModelsByImplementationYearBefore(int implementationYear) {
        return modelRepository.findModelsByImplementationYearBefore(implementationYear);
    }


}
