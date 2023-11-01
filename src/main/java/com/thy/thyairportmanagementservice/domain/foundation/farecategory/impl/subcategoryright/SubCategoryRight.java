package com.thy.thyairportmanagementservice.domain.foundation.farecategory.impl.subcategoryright;

import com.thy.thyairportmanagementservice.domain.foundation.farecategory.impl.subcategory.SubCategory;
import com.thy.thyairportmanagementservice.domain.foundation.right.impl.Right;
import com.thy.thyairportmanagementservice.library.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = SubCategoryRight.TABLE)
public class SubCategoryRight extends AbstractEntity {
    public static final String TABLE = "sub_category_right";
    public static final String COL_SUB_CATEGORY_ID = "sub_category_id";
    public static final String COL_RIGHT_ID = "right_id";

    @OneToOne
    @JoinColumn(name = COL_SUB_CATEGORY_ID)
    private SubCategory subCategory;

    @OneToOne
    @JoinColumn(name = COL_RIGHT_ID)
    private Right right;
}
