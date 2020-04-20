/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class FlightBooking {

    @Id
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @GeneratedValue(generator = "fligth-booking-code-gen")
    @GenericGenerator(name = "fligth-booking-code-gen",
            parameters = @Parameter(name = "prefix", value = "FA-FB"),
            strategy = "com.finartz.airlines.ticketing.utils.StringSequenceIdGenerator")
    @Column(name = "fligth_booking_code", updatable = false, nullable = false)
    private String flightBookingCode;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "ticket_number", updatable = false, nullable = false)
    private String ticketNumber;

    @Column(name = "fligth_code", updatable = false, nullable = false)
    private String flightCode;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "booking_status", nullable = false)
    private String bookingStatus;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "booking_amount", updatable = false, nullable = false)
    private Double bookingAmount;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "paymnet_approval_status", nullable = false)
    private String paymentApprovalStatus;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fligth_code", referencedColumnName = "fligth_code", insertable = false, updatable = false)
    private Flight fligth;

    public FlightBooking() {
    }

    public FlightBooking(String flightBookingCode, String ticketNumber, String flightCode, String bookingStatus, Double bookingAmount, String paymentApprovalStatus, Flight fligth) {
        this.flightBookingCode = flightBookingCode;
        this.ticketNumber = ticketNumber;
        this.flightCode = flightCode;
        this.bookingStatus = bookingStatus;
        this.bookingAmount = bookingAmount;
        this.paymentApprovalStatus = paymentApprovalStatus;
        this.fligth = fligth;
    }

    public String getFlightBookingCode() {
        return flightBookingCode;
    }

    public void setFlightBookingCode(String flightBookingCode) {
        this.flightBookingCode = flightBookingCode;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Double getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(Double bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public String getPaymentApprovalStatus() {
        return paymentApprovalStatus;
    }

    public void setPaymentApprovalStatus(String paymentApprovalStatus) {
        this.paymentApprovalStatus = paymentApprovalStatus;
    }

    public Flight getFligth() {
        return fligth;
    }

    public void setFligth(Flight fligth) {
        this.fligth = fligth;
    }

}
