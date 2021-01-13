package com.sdk.kop.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 活动信息查询接口请求参数封装
 *
 * @author Administrator
 */
@Data
public class KopQueryActivityInfoRequest implements Serializable {
    private static final long serialVersionUID = -991985813689656508L;

    /**
     * 非必须。活动类型，不传表示所有活动。邀请会员活动-ZHUANKE_INVITE_VIP；出单奖励活动-ORDER_NUM_REWARD
     */
    private String activityType;
}
