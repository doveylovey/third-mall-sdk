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
public class PriceInfo implements Serializable {
    private static final long serialVersionUID = 5021913920215994479L;

    /**
     * 当前价格(普通会员享受的价格)
     */
    private BigDecimal currentPrice;
    /**
     * 新用户促销价格
     */
    private BigDecimal newUserPrice;
    /**
     * 黑卡会员专享价
     */
    private BigDecimal memberCurrentPrice;
    /**
     * 拼团价格(如果是拼团商品)
     */
    private BigDecimal groupBuyPrice;
    /**
     * 市场价
     */
    private BigDecimal marketPrice;
    /**
     * 黑卡会员与普通会员价差(currentPrice - memberCurrentPrice)
     */
    private BigDecimal memberPriceSpread;
    /**
     * 折扣(暂无)
     */
    private String discountLabel;
}
