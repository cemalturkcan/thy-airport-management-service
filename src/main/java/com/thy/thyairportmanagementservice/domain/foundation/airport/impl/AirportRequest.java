package com.thy.thyairportmanagementservice.domain.foundation.airport.impl;

import com.thy.thyairportmanagementservice.domain.citycountry.city.api.CityDto;
import com.thy.thyairportmanagementservice.domain.foundation.airport.api.AirportDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AirportRequest {
    private final String id;
    private final String name;
    private final String code;
    private final CityDto city;

    public AirportDto toDto() {
        return AirportDto.builder()
                .id(id)
                .name(name)
                .code(code)
                .city(city)
                .build();
    }
}
