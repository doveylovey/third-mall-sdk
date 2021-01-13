package com.sdk.kop.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 活动列表
 *
 * @author Administrator
 */
@Data
public class QueryActivityInfo implements Serializable {
    private static final long serialVersionUID = 5021913920215994479L;

    /**
     * 活动 id
     */
    private Integer activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动类型
     */
    private String activityType;
    /**
     * 出单奖励活动：有效订单数量；邀请会员活动：有效实付会员数量
     */
    private Integer relateNum;
    /**
     * 邀请会员活动：有效轻会员数量
     */
    private Integer afterPayNum;
    /**
     * 开始时间
     */
    private Long startTime;
    /**
     * 结束时间
     */
    private Long endTime;
    /**
     * 结算状态：1-未结算；2-已结算
     */
    private Integer settleStatus;
    /**
     * 奖励金额
     */
    private BigDecimal rewardAmount;
}
