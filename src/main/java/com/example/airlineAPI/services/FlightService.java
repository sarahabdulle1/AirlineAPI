package com.example.airlineAPI.services;

import com.example.airlineAPI.models.Flight;
import com.example.airlineAPI.models.Passenger;
import com.example.airlineAPI.repositories.FlightRepository;
import com.example.airlineAPI.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;

//    methods
//    addNewFlight()--> .save()
    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }
//    displayAllFlights --> return list
    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }
//    displayFlightById --> use Id
    public Flight findFlight(long id){
        return flightRepository.findById(id).get();
    }
//    addPassengerToFlight()
//    cancelFlight() --> delete from the list
    public void deleteFlight(Long id){
        Flight flight = flightRepository.findById(id).get();
        for (Passenger passenger: flight.getPassengers()){
            passenger.removeFlight(flight);
            passengerRepository.save(passenger);
        }
        flightRepository.deleteById(id);
    }
}
