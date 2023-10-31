package com.thy.thyairportmanagementservice.domain.foundation.airport.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AirportService {
    AirportDto createAirport(AirportDto dto);

    AirportDto updateAirport(String id, AirportDto dto);

    void deleteAirport(String id);

    AirportDto getAirportDtoById(String id);

    Page<AirportDto> filter(AirportDto airportDto, Pageable pageable);
}
