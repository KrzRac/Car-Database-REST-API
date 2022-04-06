package com.example.project.services;

import com.example.project.entities.RegistrationCert;
import com.example.project.repositories.RegCertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegCertServiceImpl implements RegCertService {

    @Autowired
    private RegCertRepository regCertRepository;

    @Override
    public Iterable<RegistrationCert> listAllRegistrations() {
        return regCertRepository.findAll();
    }

    @Override
    public Optional<RegistrationCert> getRegistrationById(int id) {
        return regCertRepository.findById(id);
    }

    @Override
    public RegistrationCert saveRegistration(RegistrationCert registrationCert) {
        return regCertRepository.save(registrationCert);
    }

    @Override
    public void deleteRegistrationCert(int id) {
        regCertRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(int id) {
        return regCertRepository.checkIfExist(id) > 0;
    }
}
