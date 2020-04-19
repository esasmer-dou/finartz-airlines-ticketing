package com.finartz.airlines.ticketing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airport {

    @Id
    @Column(name = "iata_code", updatable = false, nullable = false)
    private String iataCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country_iso_code", nullable = false)
    private String countryIsoCode;

    public Airport() {
        super();
    }

    public Airport(String iataCode, String name, String countryIsoCode) {
        this.iataCode = iataCode;
        this.name = name;
        this.countryIsoCode = countryIsoCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    @Override
    public String toString() {
        return "Airport{" + "iataCode=" + iataCode + ", name=" + name + ", countryIsoCode=" + countryIsoCode + '}';
    }

}
