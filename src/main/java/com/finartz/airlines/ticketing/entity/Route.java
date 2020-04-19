/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author generic
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Route {

    @Id
    @JsonIgnore
    @JsonProperty(access = Access.READ_ONLY)
    @GeneratedValue(generator = "route-code-gen")
    @GenericGenerator(name = "route-code-gen",
            parameters = @Parameter(name = "prefix", value = "FA-R"),
            strategy = "com.finartz.airlines.ticketing.utils.StringSequenceIdGenerator")
    @Column(name = "route_code", updatable = false, nullable = false)
    private String routeCode;

    @Column(name = "source_country", nullable = false)
    private String sourceCountry;

    @Column(name = "source_city", nullable = false)
    private String sourceCity;

    @Column(name = "destination_country", nullable = false)
    private String destinationCountry;

    @Column(name = "destination_city", nullable = false)
    private String destinationCity;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = RouteDetail.class)
    private List<RouteDetail> routeDetail;

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getSourceCountry() {
        return sourceCountry;
    }

    public void setSourceCountry(String sourceCountry) {
        this.sourceCountry = sourceCountry;
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public List<RouteDetail> getRouteDetail() {
        return routeDetail;
    }

    public void setRouteDetail(List<RouteDetail> routeDetail) {
        this.routeDetail = routeDetail;
    }

}
