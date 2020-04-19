/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.flghtbooking;

import com.finartz.airlines.ticketing.entity.Flight;
import com.finartz.airlines.ticketing.entity.FlightBooking;
import com.finartz.airlines.ticketing.repository.FlightBookingRepository;
import com.finartz.airlines.ticketing.repository.FlightRepository;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author generic
 */
@Service
public class FlightBookingServiceImpl implements FlightBookingService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    @Override
    public Optional<FlightBooking> getFlightBookingByFlightBookingCode(String flightBookingCode) {
        return flightBookingRepository.findFlightBookingByFlightBookingCode(flightBookingCode);
    }

    @Override
    public Optional<FlightBooking> getFlightBookingByTicketNumber(String ticketNumber) {
        return flightBookingRepository.findFlightBookingByTicketNumber(ticketNumber);
    }

    @Override
    public List<FlightBooking> getAllFlightBookings() {
        return flightBookingRepository.getAllFlightBokkings();
    }

    @Override
    public FlightBooking createFlightBooking(FlightBooking flightBooking) {
        Flight flight = flightRepository.findFlightByFlightCode(flightBooking.getFlightCode()).get();
        int capacityCount = flight.getPassengerCapacityCount();
        int bookingCount = flightBookingCountByFlightCode(flightBooking.getFlightCode());
        flightBooking.setBookingStatus("BOOKED");
        flightBooking.setPaymentApprovalStatus("N");
        flightBooking.setTicketNumber(RandomStringUtils.randomAlphanumeric(8));
        if (bookingCount == 0) {
            flightBooking.setBookingAmount(flight.getStandardTicketPrice());
        } else {
            FlightBooking topFlightBooking = getFlightBookingTopByFlightCodeDescByFlightBookingCode(flightBooking.getFlightCode()).get();
            double fullnessRatioBeforeBooking = calculatePercentage(bookingCount, Double.valueOf(capacityCount));
            double fullnessRatioAfterBooking = calculatePercentage((bookingCount + 1), Double.valueOf(capacityCount));

            if (((fullnessRatioBeforeBooking < 10) && (fullnessRatioAfterBooking >= 10)) || ((fullnessRatioBeforeBooking < 20) && (fullnessRatioAfterBooking >= 20))
                    || ((fullnessRatioBeforeBooking < 30) && (fullnessRatioAfterBooking >= 30))) {
                flightBooking.setBookingAmount(topFlightBooking.getBookingAmount() * (1.1));
            } else {
                flightBooking.setBookingAmount(topFlightBooking.getBookingAmount());
            }
        }
        FlightBooking resultEntity = flightBookingRepository.save(flightBooking);
        resultEntity.setFligth(flightRepository.findFlightByFlightCode(resultEntity.getFlightCode()).get());

        return flightBookingRepository.save(resultEntity);
    }

    @Override
    public Optional<FlightBooking> cancelBookingByTicketNumber(String ticketNumber) {
        int result = flightBookingRepository.cancelFlightBookingByTicketNumber(ticketNumber);

        return flightBookingRepository.findFlightBookingByTicketNumber(ticketNumber);

    }

    @Override
    public int flightBookingCountByFlightCode(String flightCode) {
        return flightBookingRepository.flightBookingCountByFlightCode(flightCode);
    }

    @Override
    public Optional<FlightBooking> getFlightBookingTopByFlightCodeDescByFlightBookingCode(String flightCode) {
        return flightBookingRepository.findTopByFlightCodeAndBookingStatusOrderByFlightBookingCodeDesc(flightCode, "BOOKED");
    }

    public double calculatePercentage(double obtained, double total) {
        return obtained * 100 / total;
    }

}
