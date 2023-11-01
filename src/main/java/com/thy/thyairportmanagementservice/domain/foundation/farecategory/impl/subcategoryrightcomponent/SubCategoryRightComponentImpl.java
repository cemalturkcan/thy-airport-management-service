package com.thy.thyairportmanagementservice.domain.foundation.farecategory.impl.subcategoryrightcomponent;

import com.thy.thyairportmanagementservice.domain.foundation.farecategory.api.subcategory.SubCategoryService;
import com.thy.thyairportmanagementservice.domain.foundation.farecategory.api.subcategoryright.SubCategoryRightService;
import com.thy.thyairportmanagementservice.domain.foundation.farecategory.api.subcategoryrightcomponent.SubCategoryRightComponent;
import com.thy.thyairportmanagementservice.domain.foundation.right.api.RightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubCategoryRightComponentImpl implements SubCategoryRightComponent {

    private final SubCategoryService subCategoryService;
    private final SubCategoryRightService subCategoryRightService;
    private final RightService rightService;



}
