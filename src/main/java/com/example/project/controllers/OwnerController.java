package com.example.project.controllers;

import com.example.project.entities.Owner;
import com.example.project.repositories.OwnerRepository;
import com.example.project.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class OwnerController {


    @Autowired
    private OwnerService ownerService;

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping(value = "/owners", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Owner> list(Owner owner) {
        return ownerService.listAllOwners();
    }

    @GetMapping(value = "/owner/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Owner getById(@PathVariable("id") int id) {
        if (ownerService.checkIfExists(id).equals(true)) {
            return ownerService.getOwnerById(id).orElseGet(null);
        } else {
            return null;
        }
    }

    @PostMapping(value = "/owner")
    public ResponseEntity<Owner> create(@RequestBody Owner owner) {
        ownerService.saveOwner(owner);
        return ResponseEntity.ok().body(owner);
    }

    @PutMapping(value = "/owner")
    @ResponseStatus
    public ResponseEntity<Void> edit(@RequestBody Owner owner) {
        if(!ownerService.checkIfExists(owner.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            ownerService.saveOwner(owner);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/owner/{id}")
    public ResponseEntity<Owner> delete(@PathVariable int id) {
        ownerService.deleteOwner(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
