package com.sdk.kop.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 查询全量商品 ID 请求参数封装
 *
 * @author Administrator
 */
@Data
public class KopAllGoodsIdRequest implements Serializable {
    private static final long serialVersionUID = -991985813689656508L;

    /**
     * 必须。0-从头开始传递上一次 response 中返回的 flag，如果返回的 flag 为 -1，表示已经到尾部
     */
    private Long flag;
}
