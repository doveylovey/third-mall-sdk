package com.sdk.kop.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品基础信息
 *
 * @author Administrator
 */
@Data
public class LinkInfo implements Serializable {
    private static final long serialVersionUID = 5021913920215994479L;

    /**
     * 分享链接
     */
    private String shareUrl;
    /**
     * 分享短链接
     */
    private String shortShareUrl;
    /**
     * 商品详情页
     */
    private String goodsDetailUrl;
    /**
     * 拼团分享链接(如果是拼团商品)
     */
    private String groupBuyShareUrl;
    /**
     * 拼团分享短链接(如果是拼团商品)
     */
    private String groupBuyShortShareUrl;
    /**
     * 拼团商详页(如果是拼团商品)
     */
    private String groupBuyGoodsDetailUrl;
    /**
     * pc 端地址
     */
    private String goodsPCUrl;
    /**
     * 微信小程序唤醒二维码链接
     */
    private String miniShareUrl;
}
