package com.thy.thyairportmanagementservice.domain.foundation.city.impl;

import com.thy.thyairportmanagementservice.domain.foundation.city.api.CityDto;
import com.thy.thyairportmanagementservice.domain.foundation.city.api.CityService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository repository;

    @Override
    public City getCityById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("City not found with id: " + id)
        );
    }

    @Override
    public CityDto toDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .code(city.getCode())
                .build();
    }
}
