package com.sdk.kop.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 根据商品 ID 查询商品信息请求参数封装
 *
 * @author Administrator
 */
@Data
public class KopGoodsInfoRequest implements Serializable {
    private static final long serialVersionUID = -991985813689656508L;

    /**
     * 必须。商品 ID 列表，多个 ID 用英文逗号分隔，每次限制 20
     */
    private String goodsIds;
    /**
     * 非必须。渠道参数1
     */
    private String trackingCode1;
    /**
     * 非必须。渠道参数2
     */
    private String trackingCode2;
    /**
     * 非必须。查询纬度：0-按照 goodsIds 维度(默认)；1-按照 goodsUrl 纬度
     */
    private Integer type;
    /**
     * 非必须。解析出 url 中商品 ID，每次只能传一个
     */
    private String goodsUrl;
    /**
     * 非必须。是否需要短链接：N-不需要(响应速度快)；其他-需要
     */
    private String needShortLink;
    /**
     * 非必须。是否需要拼团信息：N-不需要；其他-需要
     */
    private String needGroupBuyInfo;
}
