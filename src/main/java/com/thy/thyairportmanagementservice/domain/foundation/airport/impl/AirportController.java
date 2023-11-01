package com.thy.thyairportmanagementservice.domain.foundation.airport.impl;

import com.thy.thyairportmanagementservice.domain.foundation.airport.api.AirportDto;
import com.thy.thyairportmanagementservice.domain.foundation.airport.api.AirportService;
import com.thy.thyairportmanagementservice.domain.citycountry.city.api.CityDto;
import com.thy.thyairportmanagementservice.domain.citycountry.country.api.CountryDto;
import com.thy.thyairportmanagementservice.library.rest.BaseController;
import com.thy.thyairportmanagementservice.library.rest.MetaResponse;
import com.thy.thyairportmanagementservice.library.rest.PageResponse;
import com.thy.thyairportmanagementservice.library.rest.Response;
import com.thy.thyairportmanagementservice.library.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airports")
@RequiredArgsConstructor
public class AirportController extends BaseController {

    private final AirportService service;

    @GetMapping("/{id}")
    public Response<AirportResponse> getById(@PathVariable(value = "id") String id) {
        AirportDto dto = service.getById(id);
        return respond(AirportResponse.fromDto(dto));
    }

    @PostMapping
    public Response<AirportResponse> create(
            @RequestBody AirportRequest request
    ) {
        AirportDto dto = service.create(request.toDto());
        return respond(AirportResponse.fromDto(dto));
    }

    @PutMapping("/{id}")
    public Response<AirportResponse> update(@PathVariable(value = "id") String id,
                                            @RequestBody AirportRequest request) {
        AirportDto dto = service.update(id, request.toDto());
        return respond(AirportResponse.fromDto(dto));
    }

    @GetMapping("/filter")
    public Response<PageResponse<AirportResponse>> filter(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "cityId", required = false) String cityId,
            @RequestParam(value = "countryId", required = false) String countryId,
            Pageable pageable) {
        AirportDto dto = AirportDto.builder()
                .keyword(keyword)
                .city(
                        CityDto.builder()
                                .id(cityId)
                                .countryId(countryId)
                                .build()
                )
                .build();
        return respond(toPageResponse(service.filter(dto, pageable)));
    }

    @DeleteMapping("/{id}")
    public Response<Void> delete(@PathVariable(value = "id") String id) {
        service.delete(id);
        return new Response<>(MetaResponse.ofSuccess());
    }

    private Page<AirportResponse> toPageResponse(Page<AirportDto> list) {
        return PageUtil.pageToDto(list, AirportResponse::fromDto);
    }

}
