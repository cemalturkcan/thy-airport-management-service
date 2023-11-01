package com.thy.thyairportmanagementservice.domain.citycountry.city.api;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CityDto {
    private final String id;
    private final String name;
    private final String code;
    private final String countryId;
}
