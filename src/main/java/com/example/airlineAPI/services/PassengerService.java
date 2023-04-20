package com.example.airlineAPI.services;

import com.example.airlineAPI.models.Flight;
import com.example.airlineAPI.models.Passenger;
import com.example.airlineAPI.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    //    methods
    public void savePassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }
    public List<Passenger> findAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger findPassenger(Long id){
        return passengerRepository.findById(id).get();
        }
}
