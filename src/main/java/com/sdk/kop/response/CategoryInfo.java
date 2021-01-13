package com.sdk.kop.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品基础信息
 *
 * @author Administrator
 */
@Data
public class CategoryInfo implements Serializable {
    private static final long serialVersionUID = 5021913920215994479L;

    /**
     * 类目 id
     */
    private Long categoryId;
    /**
     * 类目名
     */
    private String categoryName;
    /**
     * 层级
     */
    private Integer level;
}
