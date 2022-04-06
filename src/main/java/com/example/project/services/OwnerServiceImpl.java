package com.example.project.services;

import com.example.project.entities.Owner;
import com.example.project.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Iterable<Owner> listAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Optional<Owner> getOwnerById(int id) {
        return ownerRepository.findById(id);
    }

    @Override
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(int id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(int id) {
        return ownerRepository.checkIfExist(id) > 0;
    }
}
