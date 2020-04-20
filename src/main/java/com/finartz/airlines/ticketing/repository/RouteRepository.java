/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.repository;

import com.finartz.airlines.ticketing.entity.Route;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author generic
 */
@javax.transaction.Transactional(javax.transaction.Transactional.TxType.REQUIRED)
public interface RouteRepository extends JpaRepository<Route, String> {

    @Query("SELECT a FROM Route a where a.routeCode = :routeCode")
    Optional<Route> findRouteByRouteCode(@Param("routeCode") String routeCode);

    @Query("SELECT a FROM Route a")
    List<Route> getAllRoutes();

}
