package com.example.project.services;

import com.example.project.entities.Car;
import com.example.project.entities.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Iterable<Car> listAllCars();

    Optional<Car> getCarById(int id);

    Car saveCar(Car car);

    void deleteCar(int id);

    Boolean checkIfExists(int id);

    List<Car> findCarByCountry(String country);
}
