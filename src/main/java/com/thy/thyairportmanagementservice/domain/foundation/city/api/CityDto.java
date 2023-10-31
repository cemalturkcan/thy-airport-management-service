package com.thy.thyairportmanagementservice.domain.foundation.city.api;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CityDto {
    private final String id;
    private final String name;
    private final String code;
}
