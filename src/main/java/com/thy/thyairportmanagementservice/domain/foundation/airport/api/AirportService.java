package com.thy.thyairportmanagementservice.domain.foundation.airport.api;

import com.thy.thyairportmanagementservice.domain.foundation.airport.impl.Airport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AirportService {
    AirportDto create(AirportDto dto);

    AirportDto update(String id, AirportDto dto);

    void delete(String id);

    AirportDto getById(String id);

    Page<AirportDto> filter(AirportDto airportDto, Pageable pageable);

    AirportDto toDto(Airport airport);
}
