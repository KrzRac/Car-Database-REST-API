package com.example.project.entities;


import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "Właściciel", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})})
public class Owner {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "imie")
    private String firstName;

    @Column(name = "nazwisko")
    private String secondName;

    @Column(name = "adres")
    private String address;

    @Column(name = "data_kupna")
    private ZonedDateTime purchaseDate;

    public Owner() {}

    public Owner(int id, String firstName, String secondName, String address, ZonedDateTime purchaseDate) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.purchaseDate = purchaseDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPurchaseDate(ZonedDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public ZonedDateTime getPurchaseDate() {
        return purchaseDate;
    }
}
