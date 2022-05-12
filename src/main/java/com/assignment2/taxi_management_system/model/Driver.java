package com.assignment2.taxi_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table (name = "driver")
public class Driver {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private final ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column
    private String license_number;

    @Column
    private String phone_number;

    @Column
    private double rating;

    @OneToOne
    @JsonIgnore
    private Car car;

    public Driver(Long id, String license_number, String phone_number, double rating, Car car) {
        this.id = id;
        this.license_number = license_number;
        this.phone_number = phone_number;
        this.rating = rating;
        this.car = car;
    }

    public Driver() {}

    public Long getId() {
        return id;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public String getLicense_number() {
        return license_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public double getRating() {
        return rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLicense_number(String license_number) {
        this.license_number = license_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
