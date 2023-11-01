package com.thy.thyairportmanagementservice.domain.foundation.price.impl;

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
@Table(name = Price.TABLE)
public class Price extends AbstractEntity {
    public static final String TABLE = "subcategory_price";
    public static final String COL_AMOUNT = "amount";
    public static final String COL_CURRENCY = "currency";

    @Column(name = COL_AMOUNT, nullable = false)
    private BigDecimal amount;


    @Column(name = COL_CURRENCY, nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;

}
