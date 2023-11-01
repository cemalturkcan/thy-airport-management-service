package com.thy.thyairportmanagementservice.domain.foundation.flight.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FlightService {
    FlightDto getById(String id);

    FlightDto create(FlightDto dto);

    FlightDto update(String id, FlightDto dto);

    Page<FlightDto> filter(FlightDto dto, Pageable pageable);

    void delete(String id);
}
