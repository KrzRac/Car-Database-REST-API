package com.example.project.entities;

import org.apache.catalina.Engine;

import javax.persistence.*;

@Entity
@Table(name = "Samochód", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"VIN"})})
public class Car {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "VIN", unique = true)
    private String vin;

    @Column(name = "przebieg")
    private int mileage;

    @Column(name = "skrzynia_biegów")
    private String gearbox;

    @Column(name = "kraj_pochodzenia")
    private String country;

    @Column(name = "rok_produkcji")
    private int yearOfProduction;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_modelu")
    Model model;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_silnika")
    EngineType engineType;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="wlasciciel_id", referencedColumnName = "id")
    Owner owner;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "kart_poj_id", referencedColumnName = "id")
    RegistrationCert registrationCert;

    public Car() {}

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setRegistrationCert(RegistrationCert registrationCert) {
        this.registrationCert = registrationCert;
    }

    public RegistrationCert getRegistrationCert() {
        return registrationCert;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getMileage() {
        return mileage;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }
}
