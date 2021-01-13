package com.sdk.kop.response;

import lombok.Data;

import java.util.List;

/**
 * 批量转链接口响应结果
 *
 * @author Administrator
 */
@Data
public class KopShareLinkResponse extends BaseResponse<List<ShareLinkInfo>> {
    private static final long serialVersionUID = -3731062229721189667L;

}
