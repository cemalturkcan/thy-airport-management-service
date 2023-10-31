package com.thy.thyairportmanagementservice.domain.foundation.airport.api;

import com.thy.thyairportmanagementservice.domain.foundation.city.api.CityDto;
import com.thy.thyairportmanagementservice.domain.foundation.country.api.CountryDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AirportDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String name;
    private final String code;
    private final CityDto city;
    private final CountryDto country;
}
