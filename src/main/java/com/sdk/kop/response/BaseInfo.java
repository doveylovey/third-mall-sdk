package com.sdk.kop.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品基础信息
 *
 * @author Administrator
 */
@Data
public class BaseInfo implements Serializable {
    private static final long serialVersionUID = 5021913920215994479L;

    /**
     * 商品名称
     */
    private String goodsTitle;
    /**
     * 商品副标题
     */
    private String goodsSubTitle;
    /**
     * 商品图片地址
     */
    private List<String> imageList;
    /**
     * 是否自营：0-否；1-是
     */
    private Integer self;
    /**
     * 品牌名
     */
    private String brandName;
    /**
     * 品牌国简称
     */
    private String brandCountryName;
    /**
     * 是否拼团商品：0-否；1-是
     */
    private Integer groupBuyGoods;
    /**
     * 上架状态：0-下架；1-上架
     */
    private Integer onlineStatus;
    /**
     * 是否内购：0-否；1-是
     */
    private Integer interPurch;
    /**
     * 是否有库存：0-否；1-是
     */
    private Integer store;
    /**
     * 页面图文详情中的图片
     */
    private List<String> detailImgList;
    /**
     * 贸易类型：0-直邮；1-保税；2-海淘；3-国内贸易；4-个人清关
     */
    private Integer importType;
}
