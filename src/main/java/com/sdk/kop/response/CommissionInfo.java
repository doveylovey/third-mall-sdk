package com.sdk.kop.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品佣金信息
 *
 * @author Administrator
 */
@Data
public class CommissionInfo implements Serializable {
    private static final long serialVersionUID = 5021913920215994479L;

    /**
     * 一般佣金比例
     */
    private BigDecimal commissionRate;
    /**
     * 拼团佣金比例(如果是拼团商品)
     */
    private BigDecimal groupBuyCommissionRate;
    /**
     * 一般佣金有效期：0-时间段有效；1-长期有效
     */
    private Integer expireType;
    /**
     * 一般佣金开始时间，格式：yyyy-MM-dd HH:mm:ss
     */
    private String startTime;
    /**
     * 一般佣金结束时间，格式：yyyy-MM-dd HH:mm:ss
     */
    private String endTime;
    /**
     * 拼团佣金有效期：0-时间段有效；1-长期有效
     */
    private Integer groupBuyExpireType;
    /**
     * 拼团佣金开始时间，格式：yyyy-MM-dd HH:mm:ss
     */
    private String groupBuyStartTime;
    /**
     * 拼团佣金结束时间，格式：yyyy-MM-dd HH:mm:ss
     */
    private String groupBuyEndTime;
}
