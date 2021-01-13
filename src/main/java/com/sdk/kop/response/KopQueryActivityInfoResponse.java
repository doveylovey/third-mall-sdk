package com.sdk.kop.response;

import lombok.Data;

import java.util.List;

/**
 * 活动信息查询接口响应结果
 *
 * @author Administrator
 */
@Data
public class KopQueryActivityInfoResponse extends BaseResponse<List<QueryActivityInfo>> {
    private static final long serialVersionUID = -3731062229721189667L;

}
