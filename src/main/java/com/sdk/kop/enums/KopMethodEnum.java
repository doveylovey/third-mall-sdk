package com.sdk.kop.enums;

/**
 * 考拉赚客请求方法枚举类
 *
 * @author Administrator
 */
public enum KopMethodEnum {
    QUERY_RECOMMEND_GOODS_LIST("kaola.zhuanke.api.queryRecommendGoodsList", "获取推荐商品列表，每页 1000"),
    QUERY_SELECTED_GOODS("kaola.zhuanke.api.querySelectedGoods", "获取精选商品列表"),
    QUERY_GOODS_INFO("kaola.zhuanke.api.queryGoodsInfo", "根据商品 ID 查询商品信息"),
    QUERY_ORDER_INFO("kaola.zhuanke.api.queryOrderInfo", "查询订单信息。如果按时间段查询，时间段不得大于一小时"),
    //QUERY_ALL_GOODS_ID("", "查询全量商品 ID。每次返回 2000，依次查询，不要并发。发送邮件 caixi.cx@alibaba-inc.com 至申请权限"),
    QUERY_SHARE_LINK("kaola.zhuanke.api.queryShareLink", "批量转链接口。每次最多 10 个链接"),
    SEARCH_GOODS("kaola.zhuanke.api.searchGoods", "商品搜索接口"),
    QUERY_ACTIVITY_INFO("kaola.zhuanke.api.queryActivityInfo", "活动信息查询接口"),
    QUERY_ACTIVITY_ORDER("kaola.zhuanke.api.queryActivityOrder", "活动订单查询接口");

    /**
     * 方法全路径名称
     */
    private String methodName;

    /**
     * 方法作用描述
     */
    private String methodDesc;


    KopMethodEnum(String methodName, String methodDesc) {
        this.methodName = methodName;
        this.methodDesc = methodDesc;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodDesc() {
        return methodDesc;
    }

    public void setMethodDesc(String methodDesc) {
        this.methodDesc = methodDesc;
    }
}
