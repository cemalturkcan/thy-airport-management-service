package com.thy.thyairportmanagementservice.domain.citycountry.city.impl;

import com.thy.thyairportmanagementservice.domain.citycountry.city.api.CityDto;
import com.thy.thyairportmanagementservice.domain.citycountry.city.api.CityService;
import com.thy.thyairportmanagementservice.domain.citycountry.country.impl.CountryServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository repository;
    private final CountryServiceImpl countryService;

    @Override
    public CityDto get(String id) {
        return repository.findById(id)
                .map(this::toDto)
                .orElseThrow(
                        () -> new EntityNotFoundException("City not found with id: " + id)
                );
    }

    @Override
    public CityDto toDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .code(city.getCode())
                .countryId(city.getCountryId())
                .build();
    }

    @Override
    public List<City> filterCities(CityDto city) {
        return repository.filterCities(city.getId(), city.getName(), city.getCode(), city.getCountryId());
    }


}
