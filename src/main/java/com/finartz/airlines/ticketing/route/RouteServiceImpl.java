/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.route;

import com.finartz.airlines.ticketing.entity.Route;
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
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public Optional<Route> getRouteByRouteCode(String routeCode) {
        return routeRepository.findRouteByRouteCode(routeCode);
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.getAllRoutes();
    }

    @Override
    public Route createAirport(Route route) {
        return routeRepository.save(route);
    }

}
