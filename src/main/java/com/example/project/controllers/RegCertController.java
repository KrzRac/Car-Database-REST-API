package com.example.project.controllers;

import com.example.project.entities.RegistrationCert;
import com.example.project.repositories.RegCertRepository;
import com.example.project.services.RegCertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RegCertController {

    @Autowired
    private RegCertRepository regCertRepository;

    @Autowired
    private RegCertService regCertService;

    @GetMapping(value = "/registrations", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<RegistrationCert> list(RegistrationCert registrationCert) {
        return regCertService.listAllRegistrations();
    }

    @GetMapping(value = "/registration/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RegistrationCert getById(@PathVariable("id") int id) {
        if (regCertService.checkIfExists(id).equals(true)) {
            return regCertService.getRegistrationById(id).orElseGet(null);
        } else {
            return null;
        }
    }

    @PostMapping(value = "/registration")
    public Optional<RegistrationCert> create(@RequestBody RegistrationCert registrationCert) {
        regCertService.saveRegistration(registrationCert);
        return regCertRepository.findById(registrationCert.getId());
    }


    @PutMapping(value = "/registration")
    @ResponseStatus
    public ResponseEntity<Void> edit(@RequestBody RegistrationCert registrationCert) {
        if(!regCertService.checkIfExists(registrationCert.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            regCertService.saveRegistration(registrationCert);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/registration/{id}")
    public ResponseEntity<RegistrationCert> delete(@PathVariable int id) {
        regCertService.deleteRegistrationCert(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
