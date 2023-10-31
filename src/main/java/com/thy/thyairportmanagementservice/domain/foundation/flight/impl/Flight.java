package com.thy.thyairportmanagementservice.domain.foundation.flight.impl;

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
@Table(name = Flight.TABLE)
public class Flight extends AbstractEntity {
    public static final String TABLE = "flight";
    public static final String COL_ARRIVAL_DATE_TIME_DISPLAY = "arrival_date_time_display";
    public static final String COL_DEPARTURE_DATE_TIME_DISPLAY = "departure_date_time_display";
    public static final String COL_FLIGHT_DURATION = "flight_duration";


    @Column(name = COL_ARRIVAL_DATE_TIME_DISPLAY, nullable = false)
    private String arrivalDateTimeDisplay;
    @Column(name = COL_DEPARTURE_DATE_TIME_DISPLAY, nullable = false)
    private String departureDateTimeDisplay;
    @Column(name = COL_FLIGHT_DURATION, nullable = false)
    private String flightDuration;
}
