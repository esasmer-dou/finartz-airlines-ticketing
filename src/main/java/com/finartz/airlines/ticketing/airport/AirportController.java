/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.airport;

import com.finartz.airlines.ticketing.entity.Airport;
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
@RequestMapping("airport")
@Api(tags = "Airport Commands", value = "AirportCommands", description = "Controller for Airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    private static final Logger _LOG = LoggerFactory.getLogger(AirportController.class);

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get All Airports")
    public ResponseEntity<?> getAllAirports() {
        return new ResponseEntity<>(airportService.getAllAirport(), HttpStatus.OK);

    }

    @RequestMapping(value = "/{iata-code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Airport By iata Code")
    public ResponseEntity<?> getAirportByIataCode(@PathVariable("iata-code") String iataCode) {
        return new ResponseEntity<>(airportService.getAirportByIataCode(iataCode), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Airport")
    public ResponseEntity<?> createAirport(@RequestBody Airport airport) {
        return new ResponseEntity<>(airportService.createAirport(airport), HttpStatus.OK);
    }

}
