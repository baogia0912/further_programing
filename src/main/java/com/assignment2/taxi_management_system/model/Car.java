package com.assignment2.taxi_management_system.model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import com.assignment2.taxi_management_system.model.Driver;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private String license_plate;

    @Column
    private double rate;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "car", cascade = CascadeType.ALL)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Driver driver;

    public Car() {}

    public Car(long id,String VIN, String make, String model, String color, boolean convertible, double rating, String license_plate, double rate, Driver driver) {
        this.id = id;
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.color = color;
        this.convertible = convertible;
        this.rating = rating;
        this.license_plate = license_plate;
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

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
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