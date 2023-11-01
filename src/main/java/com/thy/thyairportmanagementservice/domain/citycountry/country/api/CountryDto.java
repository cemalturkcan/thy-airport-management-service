package com.thy.thyairportmanagementservice.domain.citycountry.country.api;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CountryDto {
    private final String id;
    private final String name;
    private final String code;
}
