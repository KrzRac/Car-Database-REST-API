package com.example.project.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Typ_silnika", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})})
public class EngineType {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "rodzaj_paliwa")
    private String fuel;

    @Column(name = "opis_parametrów")
    private String description;

    @OneToMany(mappedBy = "engineType", cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    private Set<Car> cars = new HashSet<Car>();

    public EngineType() {}


    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<Car> getCars() {
        return cars;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getFuel() {
        return fuel;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
