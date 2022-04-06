package com.example.project.services;

import com.example.project.entities.RegistrationCert;

import java.util.Optional;

public interface RegCertService {

    Iterable<RegistrationCert> listAllRegistrations();

    Optional<RegistrationCert> getRegistrationById(int id);

    RegistrationCert saveRegistration(RegistrationCert registrationCert);

    void deleteRegistrationCert(int id);

    Boolean checkIfExists(int id);
}
