package com.example.project.services;

import com.example.project.entities.Car;
import com.example.project.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Iterable<Car> listAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(int id) {
        return carRepository.findById(id);
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(int id) {
        return carRepository.checkIfExist(id) > 0;
    }

    @Override
    public List<Car> findCarByCountry(String country) {
        return carRepository.findCarByCountry(country);
    }

}
