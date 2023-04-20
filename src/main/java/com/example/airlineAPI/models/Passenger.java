package com.example.airlineAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="passengers")
public class Passenger {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private int phoneNumber;

    @ManyToMany(mappedBy = "passengers")
    @JsonIgnoreProperties({"passengers"})
    private List<Flight> flights;

    public Passenger(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.flights =new ArrayList<Flight>();
    }

    public Passenger(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
