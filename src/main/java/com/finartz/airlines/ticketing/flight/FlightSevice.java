/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.flight;

import com.finartz.airlines.ticketing.entity.Flight;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author generic
 */
public interface FlightSevice {

    Optional<Flight> getFlightByFlightCode(String flightCode);

    List<Flight> getAllFlights();

    List<Flight> getAllFlightsByAirlinesCompanyCode(String airlinesCompnayCode);

    Flight createFlight(Flight flight);

}
