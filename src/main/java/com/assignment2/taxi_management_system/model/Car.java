package com.assignment2.taxi_management_system.model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import com.assignment2.taxi_management_system.model.Driver;

@Entity
@Table(name= "car")
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String VIN;

    @Column
    private final ZonedDateTime dateCreated = ZonedDateTime.now();

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

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private Driver driver;

    public Car() {}

    public Car(long id,String VIN, String make, String model, String color, boolean convertible, double rating, String licence_plate, double rate, Driver driver) {
        this.id = id;
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.color = color;
        this.convertible = convertible;
        this.rating = rating;
        this.licence_plate = licence_plate;
        this.rate = rate;
        this.driver = driver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}