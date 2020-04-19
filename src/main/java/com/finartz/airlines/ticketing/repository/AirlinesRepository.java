package com.finartz.airlines.ticketing.repository;

import com.finartz.airlines.ticketing.entity.Airlines;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@javax.transaction.Transactional(javax.transaction.Transactional.TxType.REQUIRED)
public interface AirlinesRepository extends JpaRepository<Airlines, Integer> {

    @Query("SELECT a FROM Airlines a where a.companyCode = :companyCode")
    Optional<Airlines> findAirlinesByCompanyCode(@Param("companyCode") String companyCode);

    @Query("SELECT a FROM Airlines a")
    List<Airlines> getAllAirlines();    

}
