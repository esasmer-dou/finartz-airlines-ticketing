/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.flghtbooking;

import com.finartz.airlines.ticketing.entity.Airport;
import com.finartz.airlines.ticketing.entity.FlightBooking;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author generic
 */
public interface FlightBookingService {

    Optional<FlightBooking> getFlightBookingByFlightBookingCode(String flightBookingCode);

    Optional<FlightBooking> getFlightBookingByTicketNumber(String ticketNumber);

    List<FlightBooking> getAllFlightBookings();

    FlightBooking createFlightBooking(FlightBooking flightBooking);
    
    int flightBookingCountByFlightCode(String flightCode);
    
    Optional<FlightBooking> getFlightBookingTopByFlightCodeDescByFlightBookingCode(String flightCode);
    
    Optional<FlightBooking> cancelBookingByTicketNumber(String ticketNumber);

}
