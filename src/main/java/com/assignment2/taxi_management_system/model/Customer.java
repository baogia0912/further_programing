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
    private ZonedDateTime dateCreated;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phone;

    public Customer(){dateCreated = ZonedDateTime.now();}

    public Customer(long id, String name, String address, String phone) {
        this.id = id;
        dateCreated = ZonedDateTime.now();
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
