package com.sdk.kop.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 订单商品信息
 *
 * @author Administrator
 */
@Data
public class GoodItem implements Serializable {
    private static final long serialVersionUID = -3714699799887103931L;

    /**
     * itemId，唯一性保证
     */
    private String itemId;
    /**
     * 商品 ID，不唯一
     */
    private Long goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 购买件数
     */
    private Integer buyCount;
    /**
     * 佣金比例
     */
    private BigDecimal commissionRate;
    /**
     * 一级类目 id
     */
    private Long categoryId;
    /**
     * 一级类目名称
     */
    private String categoryName;
    /**
     * 商品单价(纯计算佣金的单价)
     */
    private BigDecimal unitPrice;
    /**
     * 该商品佣金
     */
    private BigDecimal commissionAmount;
    /**
     * 退款金额
     */
    private BigDecimal refundAmount;
    /**
     * type=2 时返回：商品所有类目信息，同商品信息返回对象中的类目信息
     */
    private List<CategoryInfo> categoryInfoList;
}
