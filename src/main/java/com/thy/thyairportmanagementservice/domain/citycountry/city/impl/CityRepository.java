package com.thy.thyairportmanagementservice.domain.citycountry.city.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends JpaRepository<City, String> {


    @Query("SELECT t FROM City t WHERE " +
            "(:id IS NULL OR t.id = :id) AND " +
            "(:name IS NULL OR t.name  ILIKE CONCAT('%', :name, '%')) AND " +
            "(:code IS NULL OR t.code  ILIKE CONCAT('%', :code, '%')) AND " +
            "(:countryId IS NULL OR t.countryId = :countryId)")
    List<City> filterCities(
            @Param("id") String id,
            @Param("name") String name,
            @Param("code") String code,
            @Param("countryId") String countryId
    );
}

