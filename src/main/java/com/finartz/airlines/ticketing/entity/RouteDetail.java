/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author generic
 */
@Entity
@Table(name = "route_detail")
public class RouteDetail {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id", updatable = false, nullable = false)
    private int id;

    @Column(name = "from_iata_code", updatable = false, nullable = false)
    private String fromIataCode;

    @Column(name = "to_iata_code", updatable = false, nullable = false)
    private String toIataCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_code")
    @JsonIgnore
    private Route route;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromIataCode() {
        return fromIataCode;
    }

    public void setFromIataCode(String fromIataCode) {
        this.fromIataCode = fromIataCode;
    }

    public String getToIataCode() {
        return toIataCode;
    }

    public void setToIataCode(String toIataCode) {
        this.toIataCode = toIataCode;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

}
