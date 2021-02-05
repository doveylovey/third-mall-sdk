/**
 * Copyright 2021 json.cn
 */
package com.sdk.suning.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2021-02-05 17:53:57
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
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