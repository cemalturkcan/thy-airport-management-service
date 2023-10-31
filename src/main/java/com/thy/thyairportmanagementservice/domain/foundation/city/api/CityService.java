package com.thy.thyairportmanagementservice.domain.foundation.city.api;

import com.thy.thyairportmanagementservice.domain.foundation.city.impl.City;

public interface CityService {
    City getCityById(String id);

    CityDto toDto(City city);
}
