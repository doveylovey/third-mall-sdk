package com.sdk.kop.response;

import lombok.Data;

import java.util.List;

/**
 * 活动订单查询接口响应结果
 *
 * @author Administrator
 */
@Data
public class KopQueryActivityOrderResponse extends BaseResponse<List<QueryActivityOrder>> {
    private static final long serialVersionUID = -3731062229721189667L;

}
