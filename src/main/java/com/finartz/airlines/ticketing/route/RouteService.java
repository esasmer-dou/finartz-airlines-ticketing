/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.route;

import com.finartz.airlines.ticketing.entity.Route;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author generic
 */
public interface RouteService {

    Optional<Route> getRouteByRouteCode(String routeCode);

    List<Route> getAllRoutes();

    Route createAirport(Route route);

}
