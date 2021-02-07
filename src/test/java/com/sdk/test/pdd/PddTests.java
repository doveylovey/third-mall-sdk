package com.sdk.test.pdd;

import com.alibaba.fastjson.JSON;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsDetailRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsPromotionUrlGenerateRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsSearchRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddGoodsCatsGetRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsDetailResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsPromotionUrlGenerateResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsSearchResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddGoodsCatsGetResponse;
import com.sdk.pdd.constants.PddConstants;
import com.sdk.pdd.factory.PddClientFactory;
import com.sdk.pdd.request.CustomParameter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public class PddTests {
    @Test
    public void goodsCategoryList() throws Exception {
        PddGoodsCatsGetRequest catsGetrequest = new PddGoodsCatsGetRequest();
        catsGetrequest.setParentCatId(0L);
        PddGoodsCatsGetResponse response = PddClientFactory.popClient().syncInvoke(catsGetrequest);
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void goodsList() throws Exception {
        PddDdkGoodsSearchRequest request = new PddDdkGoodsSearchRequest();
        List<Integer> activityTags = new ArrayList<>();
        Boolean iSecKill = false;
        if (iSecKill) {
            activityTags.add(PddConstants.ACTIVITY_TAGS_SECKILL);
        } else {
            activityTags.add(24);
            activityTags.add(10044);
            activityTags.add(PddConstants.ACTIVITY_TAGS_SECKILL);
            activityTags.add(PddConstants.ACTIVITY_TAGS_OTHER);
        }
        //request.setCatId(Long.valueOf());
        List<PddDdkGoodsSearchRequest.RangeListItem> rangeList = new ArrayList<>();
        PddDdkGoodsSearchRequest.RangeListItem item = new PddDdkGoodsSearchRequest.RangeListItem();
        item.setRangeFrom(30L);
        item.setRangeId(6);
        rangeList.add(item);
        request.setRangeList(rangeList);
        request.setSortType(3);
        request.setWithCoupon(true);
        request.setActivityTags(activityTags);
        request.setPage(1);
        request.setPageSize(50);
        Future<PddDdkGoodsSearchResponse> future = PddClientFactory.popClient().asyncInvoke(request);
        PddDdkGoodsSearchResponse response = future.get();
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void goodsListByKeyword() throws Exception {
        PddDdkGoodsSearchRequest request = new PddDdkGoodsSearchRequest();
        List<Integer> activityTags = new ArrayList<>();
        Boolean iSecKill = false;
        if (iSecKill) {
            activityTags.add(PddConstants.ACTIVITY_TAGS_SECKILL);
        } else {
            activityTags.add(24);
            activityTags.add(10044);
            activityTags.add(PddConstants.ACTIVITY_TAGS_SECKILL);
            activityTags.add(PddConstants.ACTIVITY_TAGS_OTHER);
        }
        String keyword = "iPhone 12";
        request.setKeyword(keyword);
        Map<String, Integer> hashMap = new HashMap<>(1);
        hashMap.put("new", 1);
        request.setCustomParameters(JSON.toJSONString(hashMap));

        //request.setCatId(Long.valueOf());
        List<PddDdkGoodsSearchRequest.RangeListItem> rangeList = new ArrayList<>();
        PddDdkGoodsSearchRequest.RangeListItem item = new PddDdkGoodsSearchRequest.RangeListItem();
        item.setRangeFrom(30L);
        item.setRangeId(6);
        rangeList.add(item);
        request.setRangeList(rangeList);
        request.setSortType(3);
        request.setWithCoupon(true);
        request.setActivityTags(activityTags);
        request.setPage(1);
        request.setPageSize(50);
        Future<PddDdkGoodsSearchResponse> future = PddClientFactory.popClient().asyncInvoke(request);
        PddDdkGoodsSearchResponse response = future.get();
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void goodsById() throws Exception {
        PddDdkGoodsDetailRequest request = new PddDdkGoodsDetailRequest();
        List<Long> goodsIdList = new ArrayList<Long>() {{
            add(214417781221L);
            //add(199774175670L);
            //add(215741383545L);
        }};
        // goodList.size() > 1 报错：只支持单个goodsId查询
        request.setGoodsIdList(goodsIdList);
        Future<PddDdkGoodsDetailResponse> asyncInvoke = PddClientFactory.popClient().asyncInvoke(request);
        PddDdkGoodsDetailResponse response = asyncInvoke.get();
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void shareLink() throws Exception {
        PddDdkGoodsPromotionUrlGenerateRequest request = new PddDdkGoodsPromotionUrlGenerateRequest();
        CustomParameter custom = new CustomParameter();
        custom.setUid("用户标识");
        request.setCustomParameters(JSON.toJSONString(custom));
        List<Long> goodsIdList = new ArrayList<Long>() {{
            add(214417781221L);
            add(199774175670L);
            add(215741383545L);
        }};
        // 可批量
        request.setGoodsIdList(goodsIdList);
        request.setPId("11655235_154083742");
        request.setGenerateWeApp(true);
        request.setGenerateWeappWebview(true);
        Future<PddDdkGoodsPromotionUrlGenerateResponse> asyncInvoke = PddClientFactory.popClient().asyncInvoke(request);
        PddDdkGoodsPromotionUrlGenerateResponse response = asyncInvoke.get();
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }
}
