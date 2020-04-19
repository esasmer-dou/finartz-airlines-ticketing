/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.airlines;

import com.finartz.airlines.ticketing.entity.Airlines;
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
@RequestMapping("airlines")
@Api(tags = "Airlines Commands", value = "AirlinesCommands", description = "Controller for Airlines")
public class AirlinesController {

    @Autowired
    private AirlinesService airlinesService;

    private static final Logger _LOG = LoggerFactory.getLogger(AirlinesController.class);

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get All Airlines")
    public ResponseEntity<?> getAirlines() {
        return new ResponseEntity<>(airlinesService.getAllAirlines(), HttpStatus.OK);

    }

    @RequestMapping(value = "/{company-code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Airlines By Company Code")
    public ResponseEntity<?> getAirlinesByCompanyCode(@PathVariable("company-code") String companyCode) {
        return new ResponseEntity<>(airlinesService.getAirlineByCompanyCode(companyCode), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Airlines")
    public ResponseEntity<?> createCompany(@RequestBody Airlines airlines) {
        return new ResponseEntity<>(airlinesService.createAirlines(airlines), HttpStatus.OK);
    }

}
