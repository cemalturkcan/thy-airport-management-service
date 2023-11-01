package com.thy.thyairportmanagementservice.domain.foundation.airport.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, String> {


    @Query("SELECT t FROM Airport t WHERE " +
            "((:keyword IS NULL OR t.name  ILIKE CONCAT('%', :keyword, '%')) OR " +
            "(:keyword IS NULL OR t.code ILIKE CONCAT('%', :keyword, '%'))) AND " +
            "((:cityIds) IS NULL OR t.cityId  IN (:cityIds))")
    Page<Airport> findLike(String keyword, List<String> cityIds, Pageable pageable);

}

