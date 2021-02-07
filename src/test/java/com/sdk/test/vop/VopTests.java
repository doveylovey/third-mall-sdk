package com.sdk.test.vop;

import com.alibaba.fastjson.JSON;
import com.sdk.common.util.AESUtil;
import com.sdk.common.util.DatetimeUtils;
import com.sdk.vop.client.VopClient;
import com.sdk.vop.enums.JxCodeCategory;
import com.vip.adp.api.open.service.GoodsInfo;
import com.vip.adp.api.open.service.GoodsInfoRequest;
import com.vip.adp.api.open.service.GoodsInfoResponse;
import com.vip.adp.api.open.service.OrderQueryModel;
import com.vip.adp.api.open.service.OrderResponse;
import com.vip.adp.api.open.service.QueryGoodsRequest;
import com.vip.adp.api.open.service.UrlGenResponse;
import com.vip.osp.sdk.exception.OspException;
import org.junit.Test;
import vipapis.category.Category;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VopTests {
    @Test
    public void goodsCategoryList() throws OspException {
        List<Category> response = VopClient.categoryServiceClient().getCategoryTreeById(0);
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void goodsList() throws OspException {
        GoodsInfoRequest request = new GoodsInfoRequest();
        request.setPage(1);
        request.setPageSize(50);
        request.setChannelType(0);
        request.setRequestId(UUID.randomUUID().toString());
        request.setFieldName("COMMISSION");
        request.setQueryStock(true);
        request.setQueryActivity(true);
        request.setQueryReputation(true);
        String categoryId = null;
        if (categoryId != null) {
            request.setJxCode(JxCodeCategory.of(categoryId));
            request.setSourceType(1);
        }
        GoodsInfoResponse response = VopClient.unionGoodsServiceClient().goodsList(request);
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void goodsListByKeyword() throws OspException {
        QueryGoodsRequest request = new QueryGoodsRequest();
        request.setKeyword("iPhone 12");
        request.setPage(1);
        request.setPageSize(50);
        request.setRequestId(UUID.randomUUID().toString());
        request.setQueryStoreServiceCapability(true);
        request.setQueryActivity(true);
        request.setQueryReputation(true);
        GoodsInfoResponse response = VopClient.unionGoodsServiceClient().query(request);
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void goodsById() throws OspException {
        List<String> goodsIdList = new ArrayList<String>() {{
            add("1575092818020178");
            add("1628809560875226");
            add("1643171201329306");
        }};
        String requestId = UUID.randomUUID().toString();
        String chanTag = "xd-vph";
        List<GoodsInfo> response = VopClient.unionGoodsServiceClient().getByGoodsIds(goodsIdList, requestId, chanTag);
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void shareLink() throws Exception {
        List<String> goodsIdList = new ArrayList<String>() {{
            add("1575092818020178");
            add("1628809560875226");
            add("1643171201329306");
        }};
        String requestId = UUID.randomUUID().toString();
        String statParam = AESUtil.encryptData("用户标识", AESUtil.IV);
        UrlGenResponse response = VopClient.unionUrlServiceClient().genByGoodsId(goodsIdList, null, requestId, statParam);
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void orderList() throws OspException {
        OrderQueryModel request = new OrderQueryModel();
        request.setRequestId(UUID.randomUUID().toString());
        request.setPage(1);
        request.setPageSize(50);
        //request.setStatus(Short.valueOf("1"));
        LocalDateTime now = LocalDateTime.now();
        request.setUpdateTimeStart(DatetimeUtils.getSeconds(now.minusMinutes(30)));
        request.setUpdateTimeEnd(DatetimeUtils.getSeconds(now));
        String orderId = null;
        if (orderId != null) {
            List<String> orderIds = new ArrayList<String>() {{
                add(orderId);
            }};
            request.setOrderSnList(orderIds);
        }
        OrderResponse response = VopClient.unionOrderServiceClient().orderList(request);
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }
}
