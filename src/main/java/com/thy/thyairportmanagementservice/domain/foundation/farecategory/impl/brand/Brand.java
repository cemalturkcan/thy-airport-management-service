package com.thy.thyairportmanagementservice.domain.foundation.farecategory.impl.brand;

import com.thy.thyairportmanagementservice.library.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = Brand.TABLE)
public class Brand extends AbstractEntity {
    public static final String TABLE = "sub_category_brand";
    public static final String COL_BRAND_CODE = "brand_code";

    @Column(name = COL_BRAND_CODE, nullable = false)
    private String brandCode;

}
