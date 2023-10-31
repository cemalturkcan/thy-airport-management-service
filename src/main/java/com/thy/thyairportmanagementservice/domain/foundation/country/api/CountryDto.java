package com.thy.thyairportmanagementservice.domain.foundation.country.api;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CountryDto {
    private final String id;
    private final String name;
    private final String code;
}
