package com.thy.thyairportmanagementservice.domain.foundation.country.api;

import com.thy.thyairportmanagementservice.domain.foundation.country.impl.Country;

public interface CountryService {
    Country getCountryById(String id);

    CountryDto toDto(Country country);
}
