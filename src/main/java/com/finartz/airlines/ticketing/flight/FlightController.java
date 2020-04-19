/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.flight;

import com.finartz.airlines.ticketing.entity.Flight;
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
@RequestMapping("flight")
@Api(tags = "Flight Commands", value = "FlightCommands", description = "Controller for Flight")
public class FlightController {
    
    @Autowired
    private FlightSevice flightSevice;
    
    private static final Logger _LOG = LoggerFactory.getLogger(FlightController.class);
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get All Flights")
    public ResponseEntity<?> getAllFlights() {
        return new ResponseEntity<>(flightSevice.getAllFlights(), HttpStatus.OK);
        
    }
    
    @RequestMapping(value = "/{flight-code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Flight By flight Code")
    public ResponseEntity<?> getFlightByFlightCode(@PathVariable("flight-code") String flightCode) {
        return new ResponseEntity<>(flightSevice.getFlightByFlightCode(flightCode), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/airlines/{company-code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Flight By flight Code")
    public ResponseEntity<?> getFlightsByAirlinesCompanyCode(@PathVariable("company-code") String companyCode) {
        return new ResponseEntity<>(flightSevice.getAllFlightsByAirlinesCompanyCode(companyCode), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Flight")
    public ResponseEntity<?> createFlight(@RequestBody Flight flight) {
        return new ResponseEntity<>(flightSevice.createFlight(flight), HttpStatus.OK);
    }
    
}
