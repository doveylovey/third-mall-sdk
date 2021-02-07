package com.sdk.vop.client;

import com.vip.adp.api.open.service.UnionGoodsServiceHelper.UnionGoodsServiceClient;
import com.vip.adp.api.open.service.UnionOrderServiceHelper.UnionOrderServiceClient;
import com.vip.adp.api.open.service.UnionUrlServiceHelper.UnionUrlServiceClient;
import com.vip.osp.sdk.context.InvocationContext;
import vipapis.category.CategoryServiceHelper.CategoryServiceClient;

public class VopClient {
    /**
     * 唯品会证书编号
     */
    static private String appKey = "fffcb116";
    /**
     * 唯品会密钥
     */
    static private String appSecret = "2ED9132B7B3880CD0F1D069BA69DC06B";
    /**
     * 唯品会api请求路径。https://vipapis.com
     */
    static private String url = "https://gw.vipapis.com";
    /**
     * 小程序跳转appId
     */
    static private String appId = "wxe9714e742209d35f";

    public static CategoryServiceClient categoryServiceClient() {
        InvocationContext invocationContext = InvocationContext.Factory.getInstance();
        invocationContext.setAppKey(appKey);
        invocationContext.setAppSecret(appSecret);
        invocationContext.setAppURL(url);
        return new CategoryServiceClient();
    }

    public static UnionGoodsServiceClient unionGoodsServiceClient() {
        InvocationContext invocationContext = InvocationContext.Factory.getInstance();
        invocationContext.setAppKey(appKey);
        invocationContext.setAppSecret(appSecret);
        invocationContext.setAppURL(url);
        return new UnionGoodsServiceClient();
    }

    public static UnionUrlServiceClient unionUrlServiceClient() {
        InvocationContext invocationContext = InvocationContext.Factory.getInstance();
        invocationContext.setAppKey(appKey);
        invocationContext.setAppSecret(appSecret);
        invocationContext.setAppURL(url);
        return new UnionUrlServiceClient();
    }

    public static UnionOrderServiceClient unionOrderServiceClient() {
        InvocationContext invocationContext = InvocationContext.Factory.getInstance();
        invocationContext.setAppKey(appKey);
        invocationContext.setAppSecret(appSecret);
        invocationContext.setAppURL(url);
        return new UnionOrderServiceClient();
    }
}
