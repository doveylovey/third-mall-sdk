package com.sdk.common.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 类目信息
 *
 * @author Administrator
 */
@Data
public class CategoryInfo implements Serializable {
    private static final long serialVersionUID = 4767396547188244294L;
    /**
     * 类目 id
     */
    private String categoryId;
    /**
     * 类目名称
     */
    private String categoryName;
    /**
     * 父级类目 id
     */
    private String parentCategoryId;
    /**
     * 类目状态
     */
    private Integer status;
    /**
     * 类目顺序
     */
    private Integer sort;
}
