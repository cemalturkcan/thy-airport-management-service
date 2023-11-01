package com.thy.thyairportmanagementservice.domain.citycountry.country.impl;

import com.thy.thyairportmanagementservice.domain.citycountry.country.api.CountryDto;
import com.thy.thyairportmanagementservice.domain.citycountry.country.api.CountryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    @Override
    public CountryDto get(String id) {
        return repository.findById(id)
                .map(this::toDto)
                .orElseThrow(
                        () -> new EntityNotFoundException("Country not found with id: " + id)
                );
    }

    @Override
    public CountryDto toDto(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .code(country.getCode())
                .build();
    }


}
