package com.example.airlineAPI.controllers;

import com.example.airlineAPI.models.Flight;
import com.example.airlineAPI.repositories.FlightRepository;
import com.example.airlineAPI.services.FlightService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("flights")
public class FlightController {

    @Autowired
    FlightService flightService;
    @Autowired
    FlightRepository flightRepository;

    @GetMapping
    public ResponseEntity<List<Flight>> displayAllFlights(){
        return new ResponseEntity<>(flightService.findAllFlights(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>> displayFlight(@PathVariable Long id){
        return new ResponseEntity(flightService.findFlight(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<List<Flight>> addFlight(@RequestBody Flight flight){
        flightService.saveFlight(flight);
        return new ResponseEntity<>(flightService.findAllFlights(),HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }
}
