package com.thy.thyairportmanagementservice.domain.foundation.airport.impl;

import com.thy.thyairportmanagementservice.domain.foundation.city.impl.City;
import com.thy.thyairportmanagementservice.domain.foundation.country.impl.Country;
import com.thy.thyairportmanagementservice.library.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = Airport.TABLE)
public class Airport extends AbstractEntity {
    public static final String TABLE = "airport";
    public static final String COL_CODE = "code";
    public static final String COL_NAME = "name";
    public static final String COL_CITY = "city";
    public static final String COL_COUNTRY = "country";

    @Column(name = COL_NAME, nullable = false)
    private String name;

    @Column(name = COL_CODE, nullable = false)
    private String code;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = COL_CITY)
    private City city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = COL_COUNTRY)
    private Country country;
}
