package com.assignment2.taxi_management_system.model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import com.assignment2.taxi_management_system.model.Driver;

@Entity
@Table(name= "car")
public class Car {

    @Id
    @Column
    private long VIN;

    @Column
    private ZonedDateTime dateCreated;

    @Column
    private String make;

    @Column
    private String model;

    @Column
    private String color;

    @Column
    private boolean convertible;

    @Column
    private double rating;

    @Column
    private String licence_plate;

    @Column
    private double rate;

    @OneToOne
    private Driver driver;

    public Car() {
        this.dateCreated = ZonedDateTime.now();
    }

    public Car(long VIN, String make, String model, String color, boolean convertible, double rating, String licence_plate, double rate) {
        this.VIN = VIN;
        this.dateCreated = ZonedDateTime.now();
        this.make = make;
        this.model = model;
        this.color = color;
        this.convertible = convertible;
        this.rating = rating;
        this.licence_plate = licence_plate;
        this.rate = rate;
    }

    public long getVIN() {
        return VIN;
    }

    public void setVIN(long VIN) {
        this.VIN = VIN;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getLicence_plate() {
        return licence_plate;
    }

    public void setLicence_plate(String licence_plate) {
        this.licence_plate = licence_plate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}