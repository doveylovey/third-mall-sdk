package com.sdk.test.jd;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.sdk.common.util.AESUtil;
import com.sdk.duomai.api.CpsOpenApi;
import com.sdk.duomai.factory.DuoMaiClientFactory;
import com.sdk.jd.enums.JDResponse;
import com.sdk.jd.factory.JDClientFactory;
import jd.union.open.category.goods.get.request.CategoryReq;
import jd.union.open.category.goods.get.request.UnionOpenCategoryGoodsGetRequest;
import jd.union.open.category.goods.get.response.CategoryResp;
import jd.union.open.category.goods.get.response.UnionOpenCategoryGoodsGetResponse;
import jd.union.open.goods.query.request.GoodsReq;
import jd.union.open.goods.query.request.UnionOpenGoodsQueryRequest;
import jd.union.open.goods.query.response.UnionOpenGoodsQueryResponse;
import jd.union.open.promotion.common.get.request.PromotionCodeReq;
import jd.union.open.promotion.common.get.request.UnionOpenPromotionCommonGetRequest;
import jd.union.open.promotion.common.get.response.UnionOpenPromotionCommonGetResponse;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class JdTests {
    @Test
    public void goodsCategoryList() throws JdException {
        UnionOpenCategoryGoodsGetRequest category = new UnionOpenCategoryGoodsGetRequest();
        CategoryReq categoryreq = new CategoryReq();
        categoryreq.setParentId(0);
        categoryreq.setGrade(0);
        category.setReq(categoryreq);
        JdClient jdClient = JDClientFactory.jdClient();
        UnionOpenCategoryGoodsGetResponse response = jdClient.execute(category);
        System.out.println("响应结果：" + JSON.toJSONString(response));
        if (JDResponse.SUCCESS == response.getCode()) {
            CategoryResp[] data = response.getData();
            for (int i = 0; i < data.length; i++) {
                CategoryResp categoryResp = data[i];
                System.out.println(JSON.toJSONString(categoryResp));
            }
        }
    }

    @Test
    public void goodsList() throws JdException {
        UnionOpenGoodsQueryRequest request = new UnionOpenGoodsQueryRequest();
        GoodsReq goodsReqDTO = new GoodsReq();
        goodsReqDTO.setPageIndex(1);
        goodsReqDTO.setPageSize(50);
        goodsReqDTO.setIsCoupon(1);
        goodsReqDTO.setIsPG(0);
        //goodsReqDTO.setCid1(652L);
        request.setGoodsReqDTO(goodsReqDTO);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        request.setTimestamp(LocalDateTime.now().format(formatter));
        UnionOpenGoodsQueryResponse response = JDClientFactory.jdClient().execute(request);
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void goodsListByKeyword() throws JdException {
        UnionOpenGoodsQueryRequest request = new UnionOpenGoodsQueryRequest();
        GoodsReq goodsReqDTO = new GoodsReq();
        goodsReqDTO.setPageIndex(1);
        goodsReqDTO.setPageSize(50);
        goodsReqDTO.setIsCoupon(1);
        goodsReqDTO.setIsPG(0);
        goodsReqDTO.setKeyword("手机");
        //goodsReqDTO.setCid1(652L);
        request.setGoodsReqDTO(goodsReqDTO);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        request.setTimestamp(LocalDateTime.now().format(formatter));
        UnionOpenGoodsQueryResponse response = JDClientFactory.jdClient().execute(request);
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void goodsById() throws JdException {
        UnionOpenGoodsQueryRequest request = new UnionOpenGoodsQueryRequest();
        GoodsReq goodsReqDTO = new GoodsReq();
        goodsReqDTO.setIsCoupon(1);
        goodsReqDTO.setIsPG(0);
        //goodsReqDTO.setCid1(652L);
        goodsReqDTO.setSkuIds(new Long[]{Long.valueOf("1086096929")});
        request.setGoodsReqDTO(goodsReqDTO);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        request.setTimestamp(LocalDateTime.now().format(formatter));
        UnionOpenGoodsQueryResponse response = JDClientFactory.jdClient().execute(request);
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void shareLink() throws JdException, UnsupportedEncodingException {
        UnionOpenPromotionCommonGetRequest request = new UnionOpenPromotionCommonGetRequest();
        PromotionCodeReq promotionCodeReq = new PromotionCodeReq();
        promotionCodeReq.setMaterialId("item.jd.com/1086096929.html");
        promotionCodeReq.setSiteId("4000336670");
        promotionCodeReq.setExt1("用户标识");
        //promotionCodeReq.setCouponUrl(request.getCouponUrl());
        request.setPromotionCodeReq(promotionCodeReq);
        UnionOpenPromotionCommonGetResponse response = JDClientFactory.jdClient().execute(request);
        System.out.println("响应结果1：" + JSON.toJSONString(response));
        if (JDResponse.SUCCESS == response.getCode()) {
            String clickURL = response.getData().getClickURL();
            System.out.println("响应结果2：" + clickURL);
            String encodeUrl = URLEncoder.encode(clickURL, "UTF-8");
            System.out.println("响应结果3：" + encodeUrl);
        }
    }
}
