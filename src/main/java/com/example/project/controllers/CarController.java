package com.example.project.controllers;

import com.example.project.entities.Car;
import com.example.project.repositories.CarRepository;
import com.example.project.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepository carRepository;

    @GetMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Car> list(Car car) {
        return carService.listAllCars();
    }

    @GetMapping(value = "/car/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car getById(@PathVariable("id") int id) {
        if (carService.checkIfExists(id).equals(true)) {
            return carService.getCarById(id).orElseGet(null);
        } else {
            return null;
        }
    }

    @GetMapping(value = "/cars/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> getByCountry(@PathVariable("country") String country) {
        return carService.findCarByCountry(country);
    }


    @PostMapping(value = "/car")
    public ResponseEntity<Car> create(@RequestBody Car car) {
        carService.saveCar(car);

        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @PutMapping(value = "/car")
    @ResponseStatus
    public ResponseEntity<Void> edit(@RequestBody Car car) {
        if(!carService.checkIfExists(car.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            carService.saveCar(car);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

   @DeleteMapping(value = "/car/{id}")
    public ResponseEntity<Car> delete(@PathVariable int id) {
        carRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
