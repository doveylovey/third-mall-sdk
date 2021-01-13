package com.sdk.test.kop;

import com.alibaba.fastjson.JSON;
import com.sdk.kop.enums.KopMethodEnum;
import com.sdk.kop.request.*;
import com.sdk.kop.response.*;
import com.sdk.kop.util.KopUtils;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 */
public class KopTests {
    @Test
    public void queryRecommendGoodsList() {
        KopRecommendGoodsListRequest request = new KopRecommendGoodsListRequest();
        request.setSortType(1);
        request.setPageIndex(1);
        request.setPageSize(20);
        try {
            String execute = KopUtils.doPost(request, KopMethodEnum.QUERY_RECOMMEND_GOODS_LIST.getMethodName());
            if (execute != null && !"".equals(execute.trim())) {
                KopRecommendGoodsListResponse response = JSON.parseObject(execute, KopRecommendGoodsListResponse.class);
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
