package com.sdk.kop.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品信息
 *
 * @author Administrator
 */
@Data
public class GoodsInfo implements Serializable {
    private static final long serialVersionUID = -2025131831775382152L;

    /**
     * 商品 Id
     */
    private Long goodsId;
    /**
     * 基础信息
     */
    private BaseInfo baseInfo;
    /**
     * 类目信息
     */
    private List<CategoryInfo> categoryInfo;
    /**
     * 价格信息
     */
    private PriceInfo priceInfo;
    /**
     * 活动信息
     */
    private ActivityInfo activityInfo;
    /**
     * 佣金信息
     */
    private CommissionInfo commissionInfo;
    /**
     * 跟踪链接
     */
    private LinkInfo linkInfo;
}
