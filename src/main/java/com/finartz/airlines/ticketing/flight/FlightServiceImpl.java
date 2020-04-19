/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.flight;

import com.finartz.airlines.ticketing.entity.Flight;
import com.finartz.airlines.ticketing.repository.AirlinesRepository;
import com.finartz.airlines.ticketing.repository.FlightRepository;
import com.finartz.airlines.ticketing.repository.RouteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author generic
 */
@Service
public class FlightServiceImpl implements FlightSevice {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirlinesRepository airlinesRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public Optional<Flight> getFlightByFlightCode(String flightCode) {
        return flightRepository.findFlightByFlightCode(flightCode);

    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.getAllFlights();
    }

    @Override
    public Flight createFlight(Flight flight) {
        Flight flightEntity = flightRepository.save(flight);

        flightEntity.setAirlines(airlinesRepository.findAirlinesByCompanyCode(flightEntity.getAirlinesCompanyCode()).get());
        flightEntity.setRoute(routeRepository.findRouteByRouteCode(flightEntity.getRouteCode()).get());

        return flightEntity;
    }

    @Override
    public List<Flight> getAllFlightsByAirlinesCompanyCode(String airlinesCompnayCode) {
        return flightRepository.findFlightByAirlinesCompanyCode(airlinesCompnayCode);
    }

}
