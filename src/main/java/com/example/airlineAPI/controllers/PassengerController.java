package com.example.airlineAPI.controllers;

import com.example.airlineAPI.models.Passenger;
import com.example.airlineAPI.services.PassengerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @GetMapping
    public ResponseEntity<List<Passenger>> displayAllPassengers(){
        return new ResponseEntity<>(passengerService.findAllPassengers(), HttpStatus.OK);
    }
    @GetMapping(value ="/{id}")
    public ResponseEntity<Passenger> displayPassenger(@PathVariable Long id){
        return new ResponseEntity<>(passengerService.findPassenger(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<List<Passenger>> addPassenger(@RequestBody Passenger passenger){
        passengerService.savePassenger(passenger);
        return new ResponseEntity<>(passengerService.findAllPassengers(),HttpStatus.CREATED);
    }

}
