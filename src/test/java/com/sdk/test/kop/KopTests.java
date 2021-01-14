package com.sdk.test.kop;

import com.alibaba.fastjson.JSON;
import com.sdk.kop.enums.KopMethodEnum;
import com.sdk.kop.request.KopGoodsInfoRequest;
import com.sdk.kop.request.KopOrderInfoRequest;
import com.sdk.kop.request.KopQueryActivityInfoRequest;
import com.sdk.kop.request.KopQueryActivityOrderRequest;
import com.sdk.kop.request.KopRecommendGoodsRequest;
import com.sdk.kop.request.KopSearchGoodsRequest;
import com.sdk.kop.request.KopSelectedGoodsRequest;
import com.sdk.kop.request.KopShareLinkRequest;
import com.sdk.kop.response.KopGoodsInfoResponse;
import com.sdk.kop.response.KopOrderInfoResponse;
import com.sdk.kop.response.KopQueryActivityInfoResponse;
import com.sdk.kop.response.KopQueryActivityOrderResponse;
import com.sdk.kop.response.KopRecommendGoodsResponse;
import com.sdk.kop.response.KopSearchGoodsResponse;
import com.sdk.kop.response.KopSelectedGoodsResponse;
import com.sdk.kop.response.KopShareLinkResponse;
import com.sdk.kop.util.KopUtils;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Administrator
 */
public class KopTests {
    /**
     * 将一个 list 分割成多个固定大小的 list
     */
    @Test
    public void test() {
        // 分割后的每个 list 大小
        int perListSize = 5;
        List<String> srcList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            srcList.add("list - " + i);
        }
        if (srcList == null || srcList.isEmpty()) {
            srcList = Collections.emptyList();
        }
        List<List<String>> result = new ArrayList<>();
        // 原 list 大小
        int srcSize = srcList.size();
        // 计算原 list 会被分割成几个小的 list
        int subListCount = (srcSize + perListSize - 1) / perListSize;
        for (int i = 0; i < subListCount; i++) {
            List<String> subList = srcList.subList(i * perListSize, (i + 1) * perListSize > srcSize ? srcSize : perListSize * (i + 1));
            result.add(subList);
        }
        System.out.println(result);
    }

    @Test
    public void queryRecommendGoodsList() {
        KopRecommendGoodsRequest request = new KopRecommendGoodsRequest();
        request.setSortType(1);
        request.setPageIndex(1);
        request.setPageSize(20);
        try {
            String execute = KopUtils.doPost(request, KopMethodEnum.QUERY_RECOMMEND_GOODS_LIST.getMethodName());
            if (execute != null && !"".equals(execute.trim())) {
                KopRecommendGoodsResponse response = JSON.parseObject(execute, KopRecommendGoodsResponse.class);
                System.out.println("结果：" + JSON.toJSONString(response));
                System.out.println("状态码：" + response.getCode());
                System.out.println("信息：" + response.getMsg());
                System.out.println("数据：" + response.getData());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void querySelectedGoods() {
        KopSelectedGoodsRequest request = new KopSelectedGoodsRequest();
        request.setPoolName("2");
        request.setPageNo(1);
        request.setPageSize(20);
        try {
            String execute = KopUtils.doPost(request, KopMethodEnum.QUERY_SELECTED_GOODS.getMethodName());
            if (execute != null && !"".equals(execute.trim())) {
                KopSelectedGoodsResponse response = JSON.parseObject(execute, KopSelectedGoodsResponse.class);
                System.out.println("结果：" + JSON.toJSONString(response));
                System.out.println("状态码：" + response.getCode());
                System.out.println("信息：" + response.getMsg());
                System.out.println("数据1：" + response.getData());
                System.out.println("数据2：" + response.getData().getGoodsIdList());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryGoodsInfo() {
        KopGoodsInfoRequest request = new KopGoodsInfoRequest();
        request.setGoodsIds("5245545,8511924,5233404,2767164,2132823,2369789,5247148,1586982,8927565,5296392,1565928,2415029,5249416,8739206,1573169,5971629,10910,5619213,5246545,6192972");
        try {
            String execute = KopUtils.doPost(request, KopMethodEnum.QUERY_GOODS_INFO.getMethodName());
            if (execute != null && !"".equals(execute.trim())) {
                KopGoodsInfoResponse response = JSON.parseObject(execute, KopGoodsInfoResponse.class);
                //System.out.println("结果：" + JSON.toJSONString(response));
                System.out.println("状态码：" + response.getCode());
                System.out.println("信息：" + response.getMsg());
                System.out.println("数据：");
                response.getData().forEach(System.out::println);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryOrderInfo() {
        KopOrderInfoRequest request = new KopOrderInfoRequest();
        request.setType(2);
        request.setStartDate(KopUtils.getMilliSeconds(LocalDateTime.now().minusDays(30)));
        request.setEndDate(KopUtils.getMilliSeconds(LocalDateTime.now()));
        request.setOrderId("10000");
        try {
            String execute = KopUtils.doPost(request, KopMethodEnum.QUERY_ORDER_INFO.getMethodName());
            if (execute != null && !"".equals(execute.trim())) {
                KopOrderInfoResponse response = JSON.parseObject(execute, KopOrderInfoResponse.class);
                System.out.println("结果：" + JSON.toJSONString(response));
                System.out.println("状态码：" + response.getCode());
                System.out.println("信息：" + response.getMsg());
                System.out.println("数据：" + response.getData());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryShareLink() {
        KopShareLinkRequest request = new KopShareLinkRequest();
        List<String> list = Arrays.asList(
                "https://goods.kaola.com/product/5246545.html",
                "https://goods.kaola.com/product/8739206.html"
        );
        request.setLinkList(JSON.toJSONString(list));
        try {
            String execute = KopUtils.doPost(request, KopMethodEnum.QUERY_SHARE_LINK.getMethodName());
            if (execute != null && !"".equals(execute.trim())) {
                KopShareLinkResponse response = JSON.parseObject(execute, KopShareLinkResponse.class);
                System.out.println("结果：" + JSON.toJSONString(response));
                System.out.println("状态码：" + response.getCode());
                System.out.println("信息：" + response.getMsg());
                System.out.println("数据：" + response.getData());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchGoods() {
        KopSearchGoodsRequest request = new KopSearchGoodsRequest();
        request.setKeyWord("iPhone 12 Pro Max");
        request.setPageNo(1);
        request.setPageSize(20);
        try {
            String execute = KopUtils.doPost(request, KopMethodEnum.SEARCH_GOODS.getMethodName());
            if (execute != null && !"".equals(execute.trim())) {
                KopSearchGoodsResponse response = JSON.parseObject(execute, KopSearchGoodsResponse.class);
                System.out.println("结果：" + JSON.toJSONString(response));
                System.out.println("状态码：" + response.getCode());
                System.out.println("信息：" + response.getMsg());
                System.out.println("数据：" + response.getData());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryActivityInfo() {
        KopQueryActivityInfoRequest request = new KopQueryActivityInfoRequest();
        try {
            String execute = KopUtils.doPost(request, KopMethodEnum.QUERY_ACTIVITY_INFO.getMethodName());
            if (execute != null && !"".equals(execute.trim())) {
                KopQueryActivityInfoResponse response = JSON.parseObject(execute, KopQueryActivityInfoResponse.class);
                System.out.println("结果：" + JSON.toJSONString(response));
                System.out.println("状态码：" + response.getCode());
                System.out.println("信息：" + response.getMsg());
                System.out.println("数据：" + response.getData());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryActivityOrder() {
        KopQueryActivityOrderRequest request = new KopQueryActivityOrderRequest();
        request.setActivityId(2);
        try {
            String execute = KopUtils.doPost(request, KopMethodEnum.QUERY_ACTIVITY_ORDER.getMethodName());
            if (execute != null && !"".equals(execute.trim())) {
                KopQueryActivityOrderResponse response = JSON.parseObject(execute, KopQueryActivityOrderResponse.class);
                System.out.println("结果：" + JSON.toJSONString(response));
                System.out.println("状态码：" + response.getCode());
                System.out.println("信息：" + response.getMsg());
                System.out.println("数据：" + response.getData());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
