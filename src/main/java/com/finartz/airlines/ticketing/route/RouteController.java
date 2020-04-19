/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.route;

import com.finartz.airlines.ticketing.entity.Route;
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
@RequestMapping("route")
@Api(tags = "Route Commands", value = "RouteCommands", description = "Controller for Route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    private static final Logger _LOG = LoggerFactory.getLogger(RouteController.class);

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get All Routes")
    public ResponseEntity<?> getAllRoutes() {
        return new ResponseEntity<>(routeService.getAllRoutes(), HttpStatus.OK);

    }

    @RequestMapping(value = "/{route-code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Route By Route Code")
    public ResponseEntity<?> getRouteByRouteCode(@PathVariable("route-code") String routeCode) {
        return new ResponseEntity<>(routeService.getRouteByRouteCode(routeCode), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Route")
    public ResponseEntity<?> createRoute(@RequestBody Route route) {

        if (route.getRouteDetail().size() > 0) {
            route.getRouteDetail().stream().forEach(routeDetail -> {
                routeDetail.setRoute(route);
            });
        }
        
        return new ResponseEntity<>(routeService.createAirport(route), HttpStatus.OK);
    }

}
