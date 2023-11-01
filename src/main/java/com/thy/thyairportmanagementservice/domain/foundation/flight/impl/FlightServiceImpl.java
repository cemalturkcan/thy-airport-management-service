package com.thy.thyairportmanagementservice.domain.foundation.flight.impl;

import com.thy.thyairportmanagementservice.domain.foundation.airport.impl.AirportServiceImpl;
import com.thy.thyairportmanagementservice.domain.foundation.flight.api.FlightDto;
import com.thy.thyairportmanagementservice.domain.foundation.flight.api.FlightService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository repository;
    private final AirportServiceImpl airportService;

    @Override
    public FlightDto getById(String id) {
        return toDto(getByIdEntity(id));
    }


    @Override
    public FlightDto create(FlightDto dto) {
        return toDto(repository.save(toEntity(new Flight(), dto)));
    }

    private Flight toEntity(Flight flight, FlightDto dto) {
        flight.setArrivalDateTimeDisplay(dto.getArrivalDateTimeDisplay());
        flight.setDepartureDateTimeDisplay(dto.getDepartureDateTimeDisplay());
        flight.setFlightDuration(dto.getFlightDuration());
        flight.setOriginAirport(
                airportService.getByIdEntity(dto.getOriginAirport().getId())
        );
        flight.setDestinationAirport(
                airportService.getByIdEntity(dto.getDestinationAirport().getId())
        );
        return flight;
    }

    @Override
    public FlightDto update(String id, FlightDto dto) {
        return null;
    }

    @Override
    public Page<FlightDto> filter(FlightDto dto, Pageable pageable) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    public Flight getByIdEntity(String id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Flight not found" + id)
        );
    }


    private FlightDto toDto(Flight flight) {
        return FlightDto.builder()
                .id(flight.getId())
                .modified(flight.getModified())
                .created(flight.getCreated())
                .arrivalDateTimeDisplay(flight.getArrivalDateTimeDisplay())
                .departureDateTimeDisplay(flight.getDepartureDateTimeDisplay())
                .flightDuration(flight.getFlightDuration())
                .originAirport(airportService.toDto(flight.getOriginAirport()))
                .destinationAirport(airportService.toDto(flight.getDestinationAirport()))
                .build();
    }
}
