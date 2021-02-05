/**
 * Copyright 2021 json.cn
 */
package com.sdk.suning.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.suning.api.entity.netalliance.CommoditydetailQueryResponse;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 由于苏宁 SDK 存在 bug，在响应结果的 body 中有内容，而 sn_body 中没有，所以需要我们自己解析 body 域中内容。
 * 本类参考 {@link CommoditydetailQueryResponse}
 *
 * @author administrator
 */
@Data
public class MyCommoditydetailQueryResponse {
    @JSONField(name = "sn_responseContent")
    private SnResponseContent snResponseContent;

    @Data
    public static class SnResponseContent {
        @JSONField(name = "sn_body")
        private SnBody snbody;
    }

    @Data
    public static class SnBody {
        private List<QueryCommoditydetail> queryCommoditydetail;
    }

    @Data
    public static class QueryCommoditydetail {
        private String orderActivity;
        private CommodityInfo commodityInfo;
        private PgInfo pgInfo;
        private CategoryInfo categoryInfo;
        private CouponInfo couponInfo;
        private AdvanceSale advanceSale;
        private List<ParametersList> parametersList;
        private List<String> subCodeList;
        private CmmdtyReviewInfo cmmdtyReviewInfo;
    }

    @Data
    public static class CommodityInfo {
        private String commodityName;
        private String commodityCode;
        private String supplierCode;
        private String supplierName;
        private List<PictureUrl> pictureUrl;
        private String sellingPoint;
        private String monthSales;
        private String snPrice;
        private String commodityPrice;
        private String commodityType;
        private String priceType;
        private String priceTypeCode;
        private String baoyou;
        private String rate;
        private String saleStatus;
        private String productUrl;
    }

    @Data
    public static class PgInfo {
        private String pgNum;
        private String pgPrice;
        private String minOrderQuantity;
        private String pgUrl;
        private String pgActionId;
    }

    @Data
    public static class CategoryInfo {
        private String firstSaleCategoryId;
        private String firstSaleCategoryName;
        private String secondSaleCategoryId;
        private String secondSaleCategoryName;
        private String thirdSaleCategoryId;
        private String thirdSaleCategoryName;
        private String firstPurchaseCategoryId;
        private String firstPurchaseCategoryName;
        private String secondPurchaseCategoryId;
        private String secondPurchaseCategoryName;
        private String thirdPurchaseCategoryId;
        private String thirdPurchaseCategoryName;
        private String goodsGroupCategoryId;
        private String goodsGroupCategoryName;
    }

    @Data
    public static class CouponInfo {
        private String couponUrl;
        private String activityId;
        private String activitySecretKey;
        private String couponValue;
        private String couponCount;
        private String couponStartTime;
        private String couponEndTime;
        private String startTime;
        private String endTime;
        private String bounsLimit;
        private String activityDescription;
        private String afterCouponPrice;
    }

    @Data
    public static class AdvanceSale {
        private String isReserveCommodity;
        private String depositAmount;
        private String depositEndTime;
    }

    @Data
    public static class ParametersList {
        private String explain;
        private String parameterDesc;
        private String sequence;
        private String parameterVal;
        private String parametersCode;
        private String parameterSequence;
        private String parametersDesc;
        private String coreFlag;
        private String parameterCode;
    }

    @Data
    public static class CmmdtyReviewInfo {
        private String goodRate;
        private String goodReviewCount;
        private String totalReviewCount;
    }

    @Data
    public static class PictureUrl {
        private String picUrl;
        private String locationId;
    }
}