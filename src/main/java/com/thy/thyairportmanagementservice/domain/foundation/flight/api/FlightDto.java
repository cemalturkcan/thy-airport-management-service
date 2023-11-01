package com.thy.thyairportmanagementservice.domain.foundation.flight.api;

import com.thy.thyairportmanagementservice.domain.foundation.airport.api.AirportDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class FlightDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String arrivalDateTimeDisplay;
    private final String departureDateTimeDisplay;
    private final String flightDuration;
    private final AirportDto originAirport;
    private final AirportDto destinationAirport;
}
