package com.example.project.repositories;

import com.example.project.entities.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer>, PagingAndSortingRepository<Car, Integer> {

    @Query("SELECT COUNT(c) from Car c where c.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("SELECT c FROM Car c WHERE c.country = :country")
    List<Car> findCarByCountry(String country);

}
