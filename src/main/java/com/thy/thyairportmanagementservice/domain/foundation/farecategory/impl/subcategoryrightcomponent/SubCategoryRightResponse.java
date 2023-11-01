package com.thy.thyairportmanagementservice.domain.foundation.farecategory.impl.subcategoryrightcomponent;

import com.thy.thyairportmanagementservice.domain.foundation.enums.Status;
import com.thy.thyairportmanagementservice.domain.foundation.price.api.PriceDto;
import com.thy.thyairportmanagementservice.domain.foundation.right.api.RightDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SubCategoryRightResponse {
    private final String brandCode;
    private final PriceDto price;
    private final Integer order;
    private final Status status;
    private List<RightDto> rights;
}
