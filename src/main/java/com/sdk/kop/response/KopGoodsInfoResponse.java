package com.sdk.kop.response;

import lombok.Data;

import java.util.List;

/**
 * 根据商品 ID 查询商品信息响应结果
 *
 * @author Administrator
 */
@Data
public class KopGoodsInfoResponse extends BaseResponse<List<GoodsInfo>> {
    private static final long serialVersionUID = -2944295262544505126L;

}