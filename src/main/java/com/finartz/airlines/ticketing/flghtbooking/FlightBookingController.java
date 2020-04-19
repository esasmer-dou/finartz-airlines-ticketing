/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.flghtbooking;

import com.finartz.airlines.ticketing.entity.Flight;
import com.finartz.airlines.ticketing.entity.FlightBooking;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author generic
 */
@RestController
@RequestMapping("flight-booking")
@Api(tags = "Flight Booking Commands", value = "FlightBookingCommands", description = "Controller for Flight Booking")
public class FlightBookingController {
    
    @Autowired
    private FlightBookingService flightBookingSevice;
    
    private static final Logger _LOG = LoggerFactory.getLogger(FlightBookingController.class);
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get All Flight Bookings")
    public ResponseEntity<?> getAllFlightBookings() {
        return new ResponseEntity<>(flightBookingSevice.getAllFlightBookings(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{flight-booking-code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Flight Boooking By Flight Booking Code")
    public ResponseEntity<?> getFlightBookingByFlightBookingCode(@PathVariable("flight-booking-code") String flightBookingCode) {
        return new ResponseEntity<>(flightBookingSevice.getFlightBookingByFlightBookingCode(flightBookingCode), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/ticket/{ticket-number}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Flight Booking By Ticket Number")
    public ResponseEntity<?> getFlightBookingByTicketNumber(@PathVariable("ticket-number") String ticketNumber) {
        return new ResponseEntity<>(flightBookingSevice.getFlightBookingByTicketNumber(ticketNumber), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Flight Booking")
    public ResponseEntity<?> createFlightBooking(@RequestBody FlightBooking flightBooking) {
        return new ResponseEntity<>(flightBookingSevice.createFlightBooking(flightBooking), HttpStatus.OK);
    }

    @RequestMapping(value = "/ticket/cancel/{ticket-number}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Cancel Flight Booking By Ticket Number")
    public ResponseEntity<?> cancelFlightBooking(@PathVariable("ticket-number") String ticketNumber) {
        return new ResponseEntity<>(flightBookingSevice.cancelBookingByTicketNumber(ticketNumber), HttpStatus.OK);
    }    
    
}
