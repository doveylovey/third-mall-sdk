package com.sdk.kop.response;

import lombok.Data;

import java.util.List;

/**
 * 查询订单信息响应结果
 *
 * @author Administrator
 */
@Data
public class KopOrderInfoResponse extends BaseResponse<List<OrderInfo>> {
    private static final long serialVersionUID = 2486719358659522589L;

}