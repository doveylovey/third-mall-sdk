package com.sdk.kop.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取精选商品列表请求参数封装
 *
 * @author Administrator
 */
@Data
public class KopSelectedGoodsRequest implements Serializable {
    private static final long serialVersionUID = -991985813689656508L;

    /**
     * 必须。精选商品池名称：
     * 1-每日平价商品；2-高佣必推商品；3-新人专享商品；4-会员专属商品；
     * 5-低价包邮商品；6-考拉自营爆款；7-考拉商家爆款；8-黑卡用户最爱买商品；
     * 9-美妆个护热销品；10-食品保健热销品；11-母婴热销品；12-时尚热销品；
     * 13-家居宠物热销品；14-每日秒杀商品；15-黑卡好价商品；16-高转化好物商品；
     * 17-开卡一单省回商品；18-会员专属促销选品池
     */
    private String poolName;
    /**
     * 非必须。页码
     */
    private Integer pageNo;
    /**
     * 非必须。每页数量：最大 200(默认)、最小 20
     */
    private Integer pageSize;
}
