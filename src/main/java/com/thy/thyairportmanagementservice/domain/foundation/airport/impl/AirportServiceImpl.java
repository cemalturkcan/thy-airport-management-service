package com.thy.thyairportmanagementservice.domain.foundation.airport.impl;

import com.thy.thyairportmanagementservice.domain.foundation.airport.api.AirportDto;
import com.thy.thyairportmanagementservice.domain.foundation.airport.api.AirportService;
import com.thy.thyairportmanagementservice.domain.foundation.city.api.CityService;
import com.thy.thyairportmanagementservice.domain.foundation.country.api.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AirportServiceImpl implements AirportService {

    private final AirportRepository repository;
    private final CityService cityService;
    private final CountryService countryService;

    @Override
    public AirportDto createAirport(AirportDto dto) {
        return toDto(repository.save(toEntity(new Airport(), dto)));
    }


    @Override
    public AirportDto updateAirport(String id, AirportDto dto) {
        return null;
    }

    @Override
    public void deleteAirport(String id) {

    }

    @Override
    public AirportDto getAirportDtoById(String id) {
        return null;
    }

    @Override
    public Page<AirportDto> filter(AirportDto airportDto, Pageable pageable) {
        return null;
    }


    private Airport toEntity(Airport airport, AirportDto dto) {
        airport.setName(dto.getName());
        airport.setCode(dto.getCode());
        airport.setCity(
                cityService.getCityById(dto.getCity().getId())
        );
        airport.setCountry(
                countryService.getCountryById(dto.getCountry().getId())
        );
        return airport;
    }


    private AirportDto toDto(Airport airport) {
        return AirportDto.builder()
                .id(airport.getId())
                .created(airport.getCreated())
                .modified(airport.getModified())
                .name(airport.getName())
                .code(airport.getCode())
                .city(
                        cityService.toDto(airport.getCity())
                )
                .country(
                        countryService.toDto(airport.getCountry())
                )
                .build();
    }

}
