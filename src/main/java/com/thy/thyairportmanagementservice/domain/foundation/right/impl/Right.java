package com.thy.thyairportmanagementservice.domain.foundation.right.impl;

import com.thy.thyairportmanagementservice.domain.foundation.enums.Currency;
import com.thy.thyairportmanagementservice.library.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = Right.TABLE)
public class Right extends AbstractEntity {
    public static final String TABLE = "right";
    public static final String RIGHT_NAME = "right_name";
    public static final String RIGHT_DESCRIPTION = "right_description";

    @Column(name = RIGHT_NAME, nullable = false)
    private String rightName;
    @Column(name = RIGHT_DESCRIPTION, nullable = false)
    private String rightDescription;

}
