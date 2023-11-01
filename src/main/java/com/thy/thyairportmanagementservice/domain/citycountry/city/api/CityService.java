package com.thy.thyairportmanagementservice.domain.citycountry.city.api;

import com.thy.thyairportmanagementservice.domain.citycountry.city.impl.City;

import java.util.List;

public interface CityService {
    CityDto get(String id);

    CityDto toDto(City city);

    List<City> filterCities(CityDto city);
}
