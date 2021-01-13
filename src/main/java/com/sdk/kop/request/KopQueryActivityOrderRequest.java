package com.sdk.kop.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 活动订单查询接口请求参数封装
 *
 * @author Administrator
 */
@Data
public class KopQueryActivityOrderRequest implements Serializable {
    private static final long serialVersionUID = -991985813689656508L;

    /**
     * 必须。活动 id
     */
    private Integer activityId;
    /**
     * 非必须。页码
     */
    private Integer pageNo;
    /**
     * 非必须。每页数量，最大 500
     */
    private Integer pageSize;
    /**
     * 非必须。订单开始时间
     */
    private Long startTime;
    /**
     * 非必须。订单结束时间
     */
    private Long endTime;
}
