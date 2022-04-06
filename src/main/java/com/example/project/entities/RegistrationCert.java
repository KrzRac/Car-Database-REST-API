package com.example.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "Karta_pojazdu")
/******** Vehicle Registration Certificate ********/
public class RegistrationCert {

    @Id
    @Column(name="id")
    private int id;

    @Column(name = "pojemność_silnika")
    private int engineCapacity;

    @Column(name = "liczba_miejsc")
    private int seatsNumber;

    @Column(name = "dopuszczalna_masa_całkowita")
    private int permissibleMass;

    public RegistrationCert() {}


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setPermissibleMass(int permissibleMass) {
        this.permissibleMass = permissibleMass;
    }

    public int getPermissibleMass() {
        return permissibleMass;
    }
}
