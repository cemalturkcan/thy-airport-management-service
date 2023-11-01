package com.thy.thyairportmanagementservice.domain.foundation.airport.impl;

import com.thy.thyairportmanagementservice.domain.citycountry.city.api.CityDto;
import com.thy.thyairportmanagementservice.domain.citycountry.city.api.CityService;
import com.thy.thyairportmanagementservice.domain.citycountry.city.impl.City;
import com.thy.thyairportmanagementservice.domain.citycountry.country.api.CountryService;
import com.thy.thyairportmanagementservice.domain.foundation.airport.api.AirportDto;
import com.thy.thyairportmanagementservice.domain.foundation.airport.api.AirportService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AirportServiceImpl implements AirportService {

    private final AirportRepository repository;
    private final CityService cityService;
    private final CountryService countryService;

    @Override
    public AirportDto create(AirportDto dto) {
        return toDto(repository.save(toEntity(new Airport(), dto)));
    }


    @Override
    public AirportDto update(String id, AirportDto dto) {
        return repository.findById(id)
                .map(airport -> toEntity(airport, dto))
                .map(repository::save)
                .map(this::toDto)
                .orElseThrow(
                        () -> new EntityNotFoundException("Airport not found" + id)
                );
    }

    @Override
    public void delete(String id) {
        Airport airport = getByIdEntity(id);
        repository.delete(airport);
    }

    @Override
    public AirportDto getById(String id) {
        return toDto(getByIdEntity(id));
    }

    public Airport getByIdEntity(String id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Airport not found" + id)
        );
    }

    @Override
    public Page<AirportDto> filter(AirportDto airportDto, Pageable pageable) {
        List<String> cityIds = null;

        if (
                airportDto.getCity().getCountryId() != null ||
                        airportDto.getCity().getId() != null
        ) {
            cityIds = cityService.filterCities(airportDto.getCity()).stream().map(City::getId).toList();
        }

        return repository.findLike(
                airportDto.getKeyword(),
                cityIds,
                pageable
        ).map(this::toDto);
    }


    private Airport toEntity(Airport airport, AirportDto dto) {
        CityDto city = dto.getCity() != null && dto.getCity().getId() != null ? cityService.get(dto.getCity().getId()) : CityDto.builder().build();
        airport.setName(dto.getName());
        airport.setCode(dto.getCode());
        airport.setCityId(
                city.getId()
        );
        airport.setCountryId(
                city.getCountryId()
        );
        return airport;
    }


    public AirportDto toDto(Airport airport) {
        return AirportDto.builder()
                .id(airport.getId())
                .created(airport.getCreated())
                .modified(airport.getModified())
                .name(airport.getName())
                .code(airport.getCode())
                .city(
                        cityService.get(airport.getCityId())
                )
                .country(
                        countryService.get(airport.getCountryId())
                )
                .build();
    }

}
