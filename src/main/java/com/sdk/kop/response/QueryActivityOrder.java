package com.sdk.kop.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单列表
 *
 * @author Administrator
 */
@Data
public class QueryActivityOrder implements Serializable {
    private static final long serialVersionUID = 5021913920215994479L;

    /**
     * 下单时间
     */
    private Long orderTime;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * tc1
     */
    private String tc1;
    /**
     * tc2
     */
    private String tc2;
    /**
     * 如果是黑卡订单：1-实付卡；2-轻会员
     */
    private Integer cardType;
    /**
     * 结算状态：0-未结算；1-已结算；2-已失效
     */
    private Integer settleStatus;
}
