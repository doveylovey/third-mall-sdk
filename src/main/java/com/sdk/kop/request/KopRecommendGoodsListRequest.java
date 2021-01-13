package com.sdk.kop.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取推荐商品列表请求参数封装
 *
 * @author Administrator
 */
@Data
public class KopRecommendGoodsListRequest implements Serializable {
    private static final long serialVersionUID = -3731062229721189667L;

    /**
     * 非必须。类目 ID，支持两级类目
     */
    private Long categoryId;
    /**
     * 必须。排序类型：
     * 1-按佣金比例排序(默认)；
     * 2-按佣金排序；
     * 3-按黑卡价格排序；
     * 4-按普通价格排序；
     * 5-按 30 天黑卡用户销量排序；
     * 6-按黑卡价差进行排序
     */
    private Integer sortType;
    /**
     * 非必须。排序方式：0-倒序(默认)、1-升序
     */
    private Integer desc;
    /**
     * 必须。页码
     */
    private Integer pageIndex;
    /**
     * 非必须。每页数量：最大 1000(默认)、最小 20
     */
    private Integer pageSize;
    /**
     * 非必须。是否自营：0-全部、1-自营、2-非自营
     */
    private Integer self;
}
