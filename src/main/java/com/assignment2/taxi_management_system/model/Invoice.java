package com.assignment2.taxi_management_system.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table (name = "invoice")
public class Invoice {
    @Id
    @Column
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private final ZonedDateTime dateCreated = ZonedDateTime.now();

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(targetEntity = Driver.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "driverId", referencedColumnName = "id")
    private Driver driver;

    private double totalCharge;

    public Invoice(){}

    public Invoice(Long id, Customer customer, Driver driver, double totalCharge) {
        this.id = id;
        this.customer = customer;
        this.driver = driver;
        this.totalCharge = totalCharge;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(double totalCharge) {
        this.totalCharge = totalCharge;
    }
}
