/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.airlines;

import com.finartz.airlines.ticketing.entity.Airlines;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author generic
 */
public interface AirlinesService {

    Optional<Airlines> getAirlineByCompanyCode(String companyCode);

    List<Airlines> getAllAirlines();
 
    Airlines createAirlines(Airlines airlines);    

}


