/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.airport;

import com.finartz.airlines.ticketing.entity.Airport;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author generic
 */
public interface AirportService {

    Optional<Airport> getAirportByIataCode(String iataCode);

    List<Airport> getAllAirport();

    Airport createAirport(Airport airport);

}
