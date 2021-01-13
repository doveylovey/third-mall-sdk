package com.sdk.kop.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 订单信息
 *
 * @author Administrator
 */
@Data
public class OrderInfo implements Serializable {
    private static final long serialVersionUID = -3117409545576592504L;

    /**
     * 订单号
     */
    private String orderId;
    /**
     * 大订单号(整体下单单号，不能做查询依据)
     */
    private String parentOrderId;
    /**
     * 渠道参数1
     */
    private String trackingCode1;
    /**
     * 渠道参数2
     */
    private String trackingCode2;
    /**
     * 下单时间
     */
    private String orderTime;
    /**
     * 支付时间
     */
    private String payTime;
    /**
     * 最后更新时间
     */
    private String lastUpdateTime;
    /**
     * 订单状态：1-已支付；2-已发货；3-交易成功；4-交易失败
     */
    private Integer orderStatus;
    /**
     * 是否售后退款：0-否；1-是
     */
    private Integer hasAfterSale;
    /**
     * 支付金额
     */
    private BigDecimal payAmount;
    /**
     * 计算佣金金额
     */
    private BigDecimal actualPayAmount;
    /**
     * 佣金
     */
    private BigDecimal commissionAmount;
    /**
     * 结算状态：0-未结算；1-已结算；2-已失效
     */
    private Integer settleStatus;
    /**
     * 订单佣金失效原因
     */
    private String noCommissionReason;
    /**
     * 是否新客首单：0-否；1-是
     */
    private Integer newAccount;
    /**
     * 设备类型：10-WEB；20-WAP；31-IOS；32-Android
     * 41-小程序 IOS；42-小程序 Android；43-小程序礼物精选 Android；44-小程序礼物精选 IOS
     */
    private Integer appType;
    /**
     * type=2 时返回：0-普通订单；1-预付订单
     */
    private Integer deposit;
    /**
     * type=2 时返回：0-普通订单；1-会员用户订单
     */
    private Integer vipOrder;
    /**
     * 订单商品信息
     */
    private List<GoodItem> goodItemList;
}
