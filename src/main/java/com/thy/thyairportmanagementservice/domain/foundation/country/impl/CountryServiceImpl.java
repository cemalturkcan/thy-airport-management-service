package com.thy.thyairportmanagementservice.domain.foundation.country.impl;

import com.thy.thyairportmanagementservice.domain.foundation.country.api.CountryDto;
import com.thy.thyairportmanagementservice.domain.foundation.country.api.CountryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    @Override
    public Country getCountryById(String id) {
        return repository.findById(id).orElseThrow(
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
