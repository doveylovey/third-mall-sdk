package com.sdk.duomai.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

@Data
public class DuoMaiOrderGoodsDetailResponse implements Serializable {

    @JSONField(name = "goods_cate")
    private String goodsCate;
    @JSONField(name = "goods_cate_name")
    private String goodsCateCame;
    @JSONField(name = "goods_id")
    private String goodsId;
    @JSONField(name = "goods_name")
    private String goodsName;
    @JSONField(name = "goods_price")
    private String goodsPrice;
    @JSONField(name = "goods_ta")
    private String goodsTa;
    @JSONField(name = "orders_price")
    private String ordersPrice;
    @JSONField(name = "order_status")
    private String orderStatus;
    @JSONField(name = "order_commission")
    private String orderCommission;
    @JSONField(name = "order_sn")
    private String orderSn;
    @JSONField(name = "parent_order_sn")
    private String parentOrderSn;
    @JSONField(name = "goods_img")
    private String goodsImg;
}
