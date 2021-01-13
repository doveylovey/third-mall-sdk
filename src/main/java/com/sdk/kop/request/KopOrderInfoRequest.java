package com.sdk.kop.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 查询订单信息请求参数封装
 *
 * @author Administrator
 */
@Data
public class KopOrderInfoRequest implements Serializable {
    private static final long serialVersionUID = -991985813689656508L;

    /**
     * 必须。查询类型：1-根据下单时间段查询；2-根据订单号查询；3-根据更新时间查询
     */
    private Integer type;
    /**
     * 非必须。查询开始时间(毫秒数)，Type 为 1、3 时必填
     */
    private Long startDate;
    /**
     * 非必须。查询结束时间(毫秒数)，Type 为 1、3 时必填
     */
    private Long endDate;
    /**
     * 非必须。订单号，Type 为 2 时必填
     */
    private String orderId;
}
