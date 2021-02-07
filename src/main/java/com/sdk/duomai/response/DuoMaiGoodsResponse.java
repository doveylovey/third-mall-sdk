package com.sdk.duomai.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DuoMaiGoodsResponse implements Serializable {

    /**
     * 商品id
     * */
    @JSONField(name = "item_id")
    private String itemId;

    /**
     *商品标题
     * */
    @JSONField(name = "item_title")
    private String itemTitle;

    /**
     *商品主图
     * */
    @JSONField(name = "item_picture")
    private String itemPicture;

    /**
     *商品小图
     * */
    @JSONField(name = "item_small_pictures")
    private List<String> itemSmallPictures;

    /**
     *商品销量
     * */
    @JSONField(name = "item_volume")
    private String itemVolume;

    /**
     *活动折扣信息
     * */
    @JSONField(name = "activity_info")
    private String activityInfo;

    /**
     *商品url
     * */
    @JSONField(name = "item_url")
    private String itemUrl;

    /**
     *商品价格
     * */
    @JSONField(name = "item_price")
    private String itemPrice;

    /**
     *优惠券面额
     * */
    @JSONField(name = "coupon_price")
    private String couponPrice;

    /**
     *优惠券面额
     * */
    @JSONField(name = "coupon")
    private String coupon;

    /**
     *券后价
     * */
    @JSONField(name = "item_final_price")
    private String itemFinalPrice;

    /**
     *类目
     * */
    @JSONField(name = "category")
    private String category;

    /**
     *佣金比例
     * */
    @JSONField(name = "commission_rate")
    private String commissionRate;

    /**
     *佣金金额
     * */
    @JSONField(name = "commission_amount")
    private String commissionAmount;

    /**
     *商品平台
     * */
    @JSONField(name = "item_platform")
    private String itemPlatform;

    /**
     *优惠开始时间
     * */
    @JSONField(name = "coupon_start_time")
    private String couponStartTime;

    /**
     *优惠结束时间
     * */
    @JSONField(name = "coupon_end_time")
    private String couponEndTime;

    /**
     *商家id
     * */
    @JSONField(name = "seller_id")
    private String sellerId;

    /**
     *商家名字
     * */
    @JSONField(name = "seller_name")
    private String sellerName;

}
