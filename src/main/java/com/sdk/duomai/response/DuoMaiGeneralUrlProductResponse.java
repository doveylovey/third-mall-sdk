package com.sdk.duomai.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DuoMaiGeneralUrlProductResponse implements Serializable {

    /**
     * 商品原始id
     * */
    @JSONField(name = "product_original_id")
    private String productId;


    /**
     * 商品名称
     * */
    @JSONField(name = "product_title")
    private String productTitle;


    /**
     * 	商品主图
     * */
    @JSONField(name = "product_main_picture")
    private String productMainPicture;


    /**
     * 商品价格
     * */
    @JSONField(name = "product_original_price")
    private String productOriginalPrice;


    /**
     * 商品优惠
     * */
    @JSONField(name = "product_coupon")
    private String productCoupon;

    /**
     * 广告主id
     * */
    @JSONField(name = "adser_id")
    private String adSerId;


}
