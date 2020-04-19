/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.repository;

import com.finartz.airlines.ticketing.entity.Airport;
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
public interface AirportRepository extends JpaRepository<Airport, String> {

    @Query("SELECT a FROM Airport a where a.iataCode = :iataCode")
    Optional<Airport> findAirportByIataCode(@Param("iataCode") String iataCode);

    @Query("SELECT a FROM Airport a")
    List<Airport> getAllAirport();

}
