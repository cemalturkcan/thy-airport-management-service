package com.thy.thyairportmanagementservice.domain.foundation.flight.impl;

import com.thy.thyairportmanagementservice.domain.foundation.flight.api.FlightDto;
import com.thy.thyairportmanagementservice.domain.foundation.flight.api.FlightService;
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
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController extends BaseController {

    private final FlightService service;

    @GetMapping("/{id}")
    public Response<FlightResponse> getById(@PathVariable(value = "id") String id) {
        FlightDto dto = service.getById(id);
        return respond(FlightResponse.fromDto(dto));
    }

    @PostMapping
    public Response<FlightResponse> create(
            @RequestBody FlightRequest request
    ) {
        FlightDto dto = service.create(request.toDto());
        return respond(FlightResponse.fromDto(dto));
    }

    @PutMapping("/{id}")
    public Response<FlightResponse> update(@PathVariable(value = "id") String id,
                                           @RequestBody FlightRequest request) {
        FlightDto dto = service.update(id, request.toDto());
        return respond(FlightResponse.fromDto(dto));
    }

    @GetMapping("/filter")
    public Response<PageResponse<FlightResponse>> filter(
            Pageable pageable) {
        FlightDto dto = FlightDto.builder()
                .build();
        return respond(toPageResponse(service.filter(dto, pageable)));
    }

    @DeleteMapping("/{id}")
    public Response<Void> delete(@PathVariable(value = "id") String id) {
        service.delete(id);
        return new Response<>(MetaResponse.ofSuccess());
    }

    private Page<FlightResponse> toPageResponse(Page<FlightDto> list) {
        return PageUtil.pageToDto(list, FlightResponse::fromDto);
    }

}
