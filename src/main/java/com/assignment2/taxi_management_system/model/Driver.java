package com.assignment2.taxi_management_system.model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table (name = "driver")
public class Driver {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private ZonedDateTime dateCreated;

    @Column
    private String license_number;

    @Column
    private String phone_number;

    @Column
    private double rating;

    @OneToOne
    private Car car;

    public Driver(long id, String license_number, String phone_number, double rating) {
        this.id = id;
        this.dateCreated = ZonedDateTime.now();
        this.license_number = license_number;
        this.phone_number = phone_number;
        this.rating = rating;
    }

    public Driver() {
        this.dateCreated = ZonedDateTime.now();
    }

    public long getId() {
        return id;
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

    public void setId(long id) {
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

}
