/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author generic
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Flight {

    @Id
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @GeneratedValue(generator = "fligth-code-gen")
    @GenericGenerator(name = "fligth-code-gen",
            parameters = @Parameter(name = "prefix", value = "FA-FC"),
            strategy = "com.finartz.airlines.ticketing.utils.StringSequenceIdGenerator")
    @Column(name = "fligth_code", updatable = false, nullable = false)
    private String flightCode;

    @Column(name = "airlines_company_code", nullable = false, updatable = false)
    private String airlinesCompanyCode;

    @Column(name = "route_code", updatable = false, nullable = false)
    private String routeCode;

    @Column(name = "departure", nullable = false, updatable = false)
    private String departure;

    @Column(name = "arrival", nullable = false, updatable = false)
    private String arrival;

    @Column(name = "departure_date", nullable = false, updatable = false)
    private LocalDateTime departureDate;

    @Column(name = "arrival_date", nullable = false, updatable = false)
    private LocalDateTime arrivalDate;

    @Column(name = "passenger_capacity_count", nullable = false)
    private Integer passengerCapacityCount;

    @Column(name = "standard_ticket_price", nullable = false)
    private Double standardTicketPrice;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "route_code", referencedColumnName = "route_code", insertable = false, updatable = false)
    private Route route;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "airlines_company_code", referencedColumnName = "company_code", insertable = false, updatable = false)
    private Airlines airlines;

    public Flight(String flightCode, String airlinesCompanyCode, String routeCode, String departure, String arrival, LocalDateTime departureDate, LocalDateTime arrivalDate, Integer passengerCapacityCount, Double standardTicketPrice, Route route, Airlines airlines) {
        this.flightCode = flightCode;
        this.airlinesCompanyCode = airlinesCompanyCode;
        this.routeCode = routeCode;
        this.departure = departure;
        this.arrival = arrival;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.passengerCapacityCount = passengerCapacityCount;
        this.standardTicketPrice = standardTicketPrice;
        this.route = route;
        this.airlines = airlines;
    }

    public Flight() {
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getAirlinesCompanyCode() {
        return airlinesCompanyCode;
    }

    public void setAirlinesCompanyCode(String airlinesCompanyCode) {
        this.airlinesCompanyCode = airlinesCompanyCode;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Integer getPassengerCapacityCount() {
        return passengerCapacityCount;
    }

    public void setPassengerCapacityCount(Integer passengerCapacityCount) {
        this.passengerCapacityCount = passengerCapacityCount;
    }

    public Double getStandardTicketPrice() {
        return standardTicketPrice;
    }

    public void setStandardTicketPrice(Double standardTicketPrice) {
        this.standardTicketPrice = standardTicketPrice;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Airlines getAirlines() {
        return airlines;
    }

    public void setAirlines(Airlines airlines) {
        this.airlines = airlines;
    }

    @Override
    public String toString() {
        return "Flight{" + "flightCode=" + flightCode + ", airlinesCompanyCode=" + airlinesCompanyCode + ", routeCode=" + routeCode + ", departure=" + departure + ", arrival=" + arrival + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", passengerCapacityCount=" + passengerCapacityCount + ", standardTicketPrice=" + standardTicketPrice + ", route=" + route + ", airlines=" + airlines + '}';
    }

}
