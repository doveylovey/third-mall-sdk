package com.sdk.kop.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品基础信息
 *
 * @author Administrator
 */
@Data
public class ActivityInfo implements Serializable {
    private static final long serialVersionUID = 5021913920215994479L;

    /**
     * 是否包邮：0-否；1-是
     */
    private Integer noPostage;
    /**
     * 活动标签(多个标签逗号分隔)
     */
    private String activityLable;
    /**
     * 是否单品减税(暂无)：0-否；1-是
     */
    private Integer singleTaxReduction;
    /**
     * 单品减税比例(暂无)
     */
    private BigDecimal singleTaxRate;
    /**
     * 是否满额减税(暂无)：0-否；1-是
     */
    private Integer fullTaxReduction;
    /**
     * 满减需达到额度(暂无)
     */
    private BigDecimal fullTaxMoney;
    /**
     * 满额减税比例(暂无)
     */
    private BigDecimal fullTaxRate;
}
