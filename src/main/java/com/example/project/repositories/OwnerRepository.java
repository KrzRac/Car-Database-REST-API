package com.example.project.repositories;

import com.example.project.entities.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Integer>, PagingAndSortingRepository<Owner, Integer> {

    @Query("SELECT COUNT(o) from Owner o where o.id = ?1")
    Integer checkIfExist(Integer id);

}
