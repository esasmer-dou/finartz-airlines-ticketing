/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.repository;

import com.finartz.airlines.ticketing.entity.Airport;
import com.finartz.airlines.ticketing.entity.FlightBooking;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author generic
 */
@javax.transaction.Transactional(javax.transaction.Transactional.TxType.REQUIRED)
public interface FlightBookingRepository extends JpaRepository<FlightBooking, String> {

    @Query("SELECT a FROM FlightBooking a where a.flightBookingCode = :flightBookingCode")
    Optional<FlightBooking> findFlightBookingByFlightBookingCode(@Param("flightBookingCode") String flightBookingCode);

    @Query("SELECT count(a) FROM FlightBooking a where a.flightCode = :flightCode and bookingStatus = 'BOOKED'")
    int flightBookingCountByFlightCode(@Param("flightCode") String flightCode);    
    
    @Query("SELECT a FROM FlightBooking a where a.ticketNumber = :ticketNumber")
    Optional<FlightBooking> findFlightBookingByTicketNumber(@Param("ticketNumber") String ticketNumber);

    Optional<FlightBooking> findTopByFlightCodeAndBookingStatusOrderByFlightBookingCodeDesc(@Param("flightCode") String flightCode,@Param("bookingStatus") String bookingStatus);

    @Query("SELECT a FROM FlightBooking a")
    List<FlightBooking> getAllFlightBokkings();

    @Modifying(clearAutomatically = true)
    @Query("UPDATE FlightBooking c SET c.bookingStatus = 'CANCELLED' WHERE c.ticketNumber = :ticketNumber")
    int cancelFlightBookingByTicketNumber(@Param("ticketNumber") String ticketNumber);

}
