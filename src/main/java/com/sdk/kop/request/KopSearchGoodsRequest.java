package com.sdk.kop.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品搜索接口请求参数封装
 *
 * @author Administrator
 */
@Data
public class KopSearchGoodsRequest implements Serializable {
    private static final long serialVersionUID = -991985813689656508L;

    /**
     * 非必须。渠道参数1
     */
    private String trackingCode1;
    /**
     * 非必须。渠道参数2
     */
    private String trackingCode2;
    /**
     * 必须。搜索关键字
     */
    private String keyWord;
    /**
     * 非必须。排序方式：0-综合排序(默认)；1-价格排序；2-销量排序；10-佣金比例排序
     */
    private Integer type;
    /**
     * 非必须。是否降序，只对价格排序方式有效：true-降序(默认)；false-升序
     */
    private Boolean desc;
    /**
     * 非必须。页码 默认第一页
     */
    private Integer pageNo;
    /**
     * 非必须。每次查询数量，默认 20
     */
    private Integer pageSize;
    /**
     * 非必须。是否跳过没有佣金的商品：true-跳过(默认)；false-不跳过
     */
    private Boolean skipNoCommission;
}
