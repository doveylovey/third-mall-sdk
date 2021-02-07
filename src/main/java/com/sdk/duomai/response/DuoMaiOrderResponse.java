package com.sdk.duomai.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DuoMaiOrderResponse implements Serializable {
    @JSONField(name = "id")
    private String orderId;

    @JSONField(name = "ads_id")
    private String adsId;

    @JSONField(name = "site_id")
    private String siteId;

    @JSONField(name = "link_id")
    private String linkId;

    @JSONField(name = "euid")
    private String euId;

    @JSONField(name = "order_sn")
    private String orderSn;

    @JSONField(name = "parent_order_sn")
    private String parentOrderSn;

    @JSONField(name = "order_time")
    private String orderTime;

    @JSONField(name = "orders_price")
    private BigDecimal ordersPrice;

    @JSONField(name = "siter_commission")
    private BigDecimal siterCommission;

    @JSONField(name = "status")
    private String status;

    @JSONField(name = "confirm_price")
    private String confirmPrice;

    @JSONField(name = "confirm_siter_commission")
    private String confirmSiterCommission;

    @JSONField(name = "charge_time")
    private String chargeTime;

    @JSONField(name = "details")
    private List<DuoMaiOrderGoodsDetailResponse> details;


}
