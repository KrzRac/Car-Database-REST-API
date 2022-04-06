package com.example.project.repositories;

import com.example.project.entities.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends CrudRepository<Model, Integer>, PagingAndSortingRepository<Model, Integer> {

    @Query("SELECT COUNT(m) from Model m where m.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("SELECT m FROM Model m WHERE m.implementationYear < :implementationYear")
    List<Model> findModelsByImplementationYearBefore(int implementationYear);


}
