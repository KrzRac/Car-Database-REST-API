package com.example.project.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Model", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})})
public class Model {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nazwa")
    private String name;

    @Column(name = "rok_wprowadzenia")
    @Max(value = 2025)
    private int implementationYear;

    @Column(name = "następnik")
    private String nextGeneration;

    @Column(name = "marka")
    private String company;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    private Set<Car> cars = new HashSet<>();

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public Model(int id, String name, int implementationYear, String nextGeneration, String company) {
        this.id = id;
        this.name = name;
        this.implementationYear = implementationYear;
        this.nextGeneration = nextGeneration;
        this.company = company;
    }

    public Model() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setImplementationYear(int implementationYear) {
        this.implementationYear = implementationYear;
    }

    public int getImplementationYear() {
        return implementationYear;
    }

    public void setNextGeneration(String nextGeneration) {
        this.nextGeneration = nextGeneration;
    }

    public String getNextGeneration() {
        return nextGeneration;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }
}


