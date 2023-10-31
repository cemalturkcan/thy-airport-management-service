package com.thy.thyairportmanagementservice.domain.foundation.airport.impl;

import com.thy.thyairportmanagementservice.domain.foundation.airport.api.AirportDto;
import com.thy.thyairportmanagementservice.domain.foundation.city.api.CityDto;
import com.thy.thyairportmanagementservice.domain.foundation.country.api.CountryDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AirportRequest {
    private final String id;
    private final String name;
    private final String code;
    private final CityDto city;
    private final CountryDto country;

    public AirportDto toDto() {
        return AirportDto.builder()
                .id(id)
                .name(name)
                .code(code)
                .city(city)
                .country(country)
                .build();
    }
}
