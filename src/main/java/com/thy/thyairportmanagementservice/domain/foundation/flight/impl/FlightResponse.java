package com.thy.thyairportmanagementservice.domain.foundation.flight.impl;

import com.thy.thyairportmanagementservice.domain.foundation.airport.impl.AirportResponse;
import com.thy.thyairportmanagementservice.domain.foundation.flight.api.FlightDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightResponse {
    private final String id;
    private final String arrivalDateTimeDisplay;
    private final String departureDateTimeDisplay;
    private final String flightDuration;
    private final AirportResponse originAirport;
    private final AirportResponse destinationAirport;


    public static FlightResponse fromDto(FlightDto dto) {
        return FlightResponse.builder()
                .id(dto.getId())
                .arrivalDateTimeDisplay(dto.getArrivalDateTimeDisplay())
                .departureDateTimeDisplay(dto.getDepartureDateTimeDisplay())
                .flightDuration(dto.getFlightDuration())
                .originAirport(AirportResponse.fromDto(dto.getOriginAirport()))
                .destinationAirport(AirportResponse.fromDto(dto.getDestinationAirport()))
                .build();
    }

}
