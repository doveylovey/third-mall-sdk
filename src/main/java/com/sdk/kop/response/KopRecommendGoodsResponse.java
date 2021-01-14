package com.sdk.kop.response;

import lombok.Data;

import java.util.List;

/**
 * 获取推荐商品列表响应结果
 *
 * @author Administrator
 */
@Data
public class KopRecommendGoodsResponse extends BaseResponse<List<Long>> {
    private static final long serialVersionUID = -3731062229721189667L;

}
