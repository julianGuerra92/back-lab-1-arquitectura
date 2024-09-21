package com.udea.consulta.service;

import com.udea.consulta.model.Flight;
import com.udea.consulta.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> searchFlights(LocalDate startDate, LocalDate endDate, String origin, Double price,String destination, String baggageType, String classType, Integer maxNumberPassengers) {
        return flightRepository.findFlightsByCriteria(startDate, endDate, origin, price,destination, baggageType, classType, maxNumberPassengers);
    }
}