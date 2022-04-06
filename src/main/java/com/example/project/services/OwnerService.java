package com.example.project.services;

import com.example.project.entities.Owner;

import java.util.Optional;

public interface OwnerService {

    Iterable<Owner> listAllOwners();

    Optional<Owner> getOwnerById(int id);

    Owner saveOwner(Owner owner);

    void deleteOwner(int id);

    Boolean checkIfExists(int id);


}
