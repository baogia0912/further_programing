package com.assignment2.taxi_management_system.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table (name = "customer")
public class Customer {
    @Id
    @Column
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private final ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phone_number;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

    public Customer(){}

    public Customer(long id, String name, String address, String phone_number, Booking booking) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.booking = booking;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone) {
        this.phone_number = phone;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
