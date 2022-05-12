package com.assignment2.taxi_management_system.model;
import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name= "booking")
public class Booking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private final ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column
    private String startLocation;

    @Column
    private String endLocation;

    @Column
    private String pickUpDateTime;

    @Column
    private String dropOffDateTime;

    @Column
    private double distance;

    public Booking(){}

    public Booking(Long id, String startLocation, String endLocation, String pickUpDateTime, String dropOffDateTime, double distance) {
        this.id = id;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.pickUpDateTime = pickUpDateTime;
        this.dropOffDateTime = dropOffDateTime;
        this.distance = distance;
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

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public String getPickUpDateTime() {
        return pickUpDateTime;
    }

    public void setPickUpDateTime(String pickUpDateTime) {
        this.pickUpDateTime = pickUpDateTime;
    }

    public String getDropOffDateTime() {
        return dropOffDateTime;
    }

    public void setDropOffDateTime(String dropOffDateTime) {
        this.dropOffDateTime = dropOffDateTime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
