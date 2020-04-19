/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finartz.airlines.ticketing.airlines;

import com.finartz.airlines.ticketing.entity.Airlines;
import com.finartz.airlines.ticketing.repository.AirlinesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author generic
 */
@Service
public class AirlinesServiceImpl implements AirlinesService {

    @Autowired
    private AirlinesRepository airlinesRepository;

    @Override
    public Optional<Airlines> getAirlineByCompanyCode(String companyCode) {
        return airlinesRepository.findAirlinesByCompanyCode(companyCode);
    }

    @Override
    public List<Airlines> getAllAirlines() {
        return airlinesRepository.getAllAirlines();
    }

    @Override
    public Airlines createAirlines(Airlines airlines) {
        return airlinesRepository.save(airlines);
    }

}
