package com.example.project.repositories;

import com.example.project.entities.RegistrationCert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegCertRepository extends CrudRepository<RegistrationCert, Integer>,
        PagingAndSortingRepository<RegistrationCert, Integer> {

    @Query("SELECT COUNT(r) from RegistrationCert r where r.id = ?1")
    Integer checkIfExist(Integer id);

}
