package com.thy.thyairportmanagementservice.domain.foundation.city.impl;

import com.thy.thyairportmanagementservice.library.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = City.TABLE)
public class City extends AbstractEntity {
    public static final String TABLE = "city";
    public static final String COL_CODE = "code";
    public static final String COL_NAME = "name";
    public static final String COL_COUNTRY_ID = "country_id";

    @Column(name = COL_NAME, nullable = false)
    private String name;

    @Column(name = COL_CODE, nullable = false)
    private String code;

    @Column(name = COL_COUNTRY_ID, nullable = false)
    private String countryId;

}
