/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.repository;

import com.finartz.airlines.ticketing.entity.Flight;
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
public interface FlightRepository extends JpaRepository<Flight, String> {

    @Query("SELECT a FROM Flight a where a.flightCode = :flightCode")
    Optional<Flight> findFlightByFlightCode(@Param("flightCode") String flightCode);

    @Query("SELECT a FROM Flight a where a.airlinesCompanyCode = :airlinesCompanyCode")
    List<Flight> findFlightByAirlinesCompanyCode(@Param("airlinesCompanyCode") String airlinesCompanyCode);

    @Query("SELECT a FROM Flight a")
    List<Flight> getAllFlights();

}
