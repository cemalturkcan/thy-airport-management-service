package com.thy.thyairportmanagementservice.domain.foundation.farecategory.impl.subcategory;

import com.thy.thyairportmanagementservice.domain.foundation.enums.FareCategory;
import com.thy.thyairportmanagementservice.domain.foundation.enums.Status;
import com.thy.thyairportmanagementservice.domain.foundation.farecategory.impl.brand.Brand;
import com.thy.thyairportmanagementservice.domain.foundation.flight.impl.Flight;
import com.thy.thyairportmanagementservice.domain.foundation.price.impl.Price;
import com.thy.thyairportmanagementservice.library.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = SubCategory.TABLE)
public class SubCategory extends AbstractEntity {
    public static final String TABLE = "sub_category";
    public static final String COL_CATEGORY = "category";
    public static final String COL_SUB_CATEGORY_BRAND_ID = "sub_category_brand_id";
    public static final String COL_PRICE_ID = "price_id";
    public static final String COL_ORDER = "order";
    public static final String COL_STATUS = "status";
    public static final String COL_FLIGHT_ID = "flight_id";

    @Column(name = COL_CATEGORY)
    @Enumerated(EnumType.STRING)
    private FareCategory fareCategory;

    @OneToOne
    @JoinColumn(name = COL_FLIGHT_ID)
    private Flight flight;

    @OneToOne
    @JoinColumn(name = COL_SUB_CATEGORY_BRAND_ID)
    private Brand brand;


    @Column(name = COL_ORDER, nullable = false)
    private Integer order;

    @Column(name = COL_STATUS)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = COL_PRICE_ID)
    private Price price;
}
