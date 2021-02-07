/**
 * Copyright 2021 json.cn
 */
package com.sdk.suning.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.suning.api.entity.netalliance.OrdersettlenewGetResponse;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 由于苏宁 SDK 存在 bug，在响应结果的 body 中有内容，而 sn_body 中没有，所以需要我们自己解析 body 域中内容。
 * 本类参考 {@link OrdersettlenewGetResponse}
 *
 * @author administrator
 */
@Data
public class MyOrdersettlenewGetResponse {
    @JSONField(name = "sn_responseContent")
    private SnResponseContent snResponseContent;

    @Data
    public static class SnResponseContent {
        @JSONField(name = "sn_body")
        private SnBody snBody;
    }

    @Data
    public static class SnBody {
        private GetOrdersettlenew getOrdersettlenew;
    }

    @Data
    public static class GetOrdersettlenew {
        private List<SettlementInfo> settlementInfo;
    }

    @Data
    public static class SettlementInfo {
        private String sellName;
        private String needPayCommission;
        private String saleType;
        private String productThirdCatalog;
        private String productSecondCatalog;
        private String orderLineStatusDesc;
        private String productName;
        private String orderLineFlag;
        private String commissionRatio;
        private String sellerCode;
        private String returnCommission;
        private String payAmount;
        private String prePayCommission;
        private String productFirstCatalog;
        private String orderCode;
        private String isGrant;
        private String orderLineNumber;
        private String goodsNum;
        private Date orderLineStatusChangeTime;
        private String isWholesale;
        private String childAccountId;
    }
}