package com.thy.thyairportmanagementservice.domain.foundation.airport.impl;

import com.thy.thyairportmanagementservice.domain.citycountry.city.api.CityDto;
import com.thy.thyairportmanagementservice.domain.citycountry.country.api.CountryDto;
import com.thy.thyairportmanagementservice.domain.foundation.airport.api.AirportDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AirportResponse {
    private final String id;
    private final String name;
    private final String code;
    private final CityDto city;
    private final CountryDto country;


    public static AirportResponse fromDto(AirportDto dto) {
        return AirportResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .code(dto.getCode())
                .city(dto.getCity())
                .country(dto.getCountry())
                .build();
    }

}
