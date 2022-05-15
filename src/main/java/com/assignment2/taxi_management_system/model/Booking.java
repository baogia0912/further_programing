package com.assignment2.taxi_management_system.model;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
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
    private ZonedDateTime pickUpDateTime;

    @Column
    private ZonedDateTime dropOffDateTime;

    @Column
    private double distance;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;

    public Booking(){}

    public Booking(Long id, String startLocation, String endLocation, ZonedDateTime pickUpDateTime, ZonedDateTime dropOffDateTime, double distance, Invoice invoice) {
        this.id = id;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.pickUpDateTime = pickUpDateTime;
        this.dropOffDateTime = dropOffDateTime;
        this.distance = distance;
        this.invoice = invoice;
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

    public ZonedDateTime getPickUpDateTime() {
        return pickUpDateTime;
    }

    public void setPickUpDateTime(ZonedDateTime pickUpDateTime) {
        this.pickUpDateTime = pickUpDateTime;
    }

    public ZonedDateTime getDropOffDateTime() {
        return dropOffDateTime;
    }

    public void setDropOffDateTime(ZonedDateTime dropOffDateTime) {
        this.dropOffDateTime = dropOffDateTime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
