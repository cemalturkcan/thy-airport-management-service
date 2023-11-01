package com.thy.thyairportmanagementservice.domain.citycountry.country.api;

import com.thy.thyairportmanagementservice.domain.citycountry.country.impl.Country;

public interface CountryService {
    CountryDto toDto(Country country);

    CountryDto get(String countryId);
}
