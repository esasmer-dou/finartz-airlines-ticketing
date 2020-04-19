/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.airport;

import com.finartz.airlines.ticketing.entity.Airport;
import com.finartz.airlines.ticketing.repository.AirlinesRepository;
import com.finartz.airlines.ticketing.repository.AirportRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author generic
 */
@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Optional<Airport> getAirportByIataCode(String iataCode) {
        return airportRepository.findAirportByIataCode(iataCode);
    }

    @Override
    public List<Airport> getAllAirport() {
        return airportRepository.getAllAirport();
    }

    @Override
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

}
