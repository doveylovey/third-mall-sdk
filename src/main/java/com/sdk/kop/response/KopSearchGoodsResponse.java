package com.sdk.kop.response;

import lombok.Data;

import java.util.List;

/**
 * 商品搜索接口响应结果
 *
 * @author Administrator
 */
@Data
public class KopSearchGoodsResponse extends BaseResponse<List<SearchGoodsLinkInfo>> {
    private static final long serialVersionUID = -3731062229721189667L;

}
