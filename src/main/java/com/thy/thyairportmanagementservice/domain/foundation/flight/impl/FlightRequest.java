package com.thy.thyairportmanagementservice.domain.foundation.flight.impl;

import com.thy.thyairportmanagementservice.domain.foundation.airport.impl.AirportRequest;
import com.thy.thyairportmanagementservice.domain.foundation.flight.api.FlightDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FlightRequest {
    private final String arrivalDateTimeDisplay;
    private final String departureDateTimeDisplay;
    private final String flightDuration;
    private final AirportRequest originAirport;
    private final AirportRequest destinationAirport;

    public FlightDto toDto() {
        return FlightDto.builder()
                .arrivalDateTimeDisplay(arrivalDateTimeDisplay)
                .departureDateTimeDisplay(departureDateTimeDisplay)
                .flightDuration(flightDuration)
                .originAirport(originAirport.toDto())
                .destinationAirport(destinationAirport.toDto())
                .build();
    }
}
