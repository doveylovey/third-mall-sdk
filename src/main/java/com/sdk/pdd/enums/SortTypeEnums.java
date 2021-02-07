package com.sdk.pdd.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum SortTypeEnums {
    PRICE_ASC(1, 9, "券后价升序排序"),
    PRICE_DESC(2, 10, "券后价降序排序");

    private int rangId;
    private Integer sortType;
    private String sortDesc;
}
