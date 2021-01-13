package com.sdk.kop.test;

import com.alibaba.fastjson.JSON;
import com.sdk.kop.enums.MethodEnum;
import com.sdk.kop.request.KopGoodsInfoRequest;
import com.sdk.kop.request.KopOrderInfoRequest;
import com.sdk.kop.request.KopRecommendGoodsListRequest;
import com.sdk.kop.request.KopSelectedGoodsRequest;
import com.sdk.kop.response.KopGoodsInfoResponse;
import com.sdk.kop.response.KopRecommendGoodsListResponse;
import com.sdk.kop.response.KopSelectedGoodsResponse;
import com.sdk.kop.util.KopUtils;

import java.time.LocalDateTime;

/**
 * @author Administrator
 */
public class KopTests {
    public static void main(String[] args) {
        //queryRecommendGoodsList();
        //querySelectedGoods();
        //queryGoodsInfo();
        queryOrderInfo();
        //queryShareLink();
        //searchGoods();
        //queryActivityInfo();
        //queryActivityOrder();
    }

    public static void queryRecommendGoodsList() {
        KopRecommendGoodsListRequest request = new KopRecommendGoodsListRequest();
        request.setSortType(1);
        request.setPageIndex(1);
        request.setPageSize(20);
        try {
            String execute = KopUtils.doPost(request, MethodEnum.QUERY_RECOMMEND_GOODS_LIST.getMethodName());
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

    public static void querySelectedGoods() {
        KopSelectedGoodsRequest request = new KopSelectedGoodsRequest();
        request.setPoolName("2");
        request.setPageNo(1);
        request.setPageSize(20);
        try {
            String execute = KopUtils.doPost(request, MethodEnum.QUERY_SELECTED_GOODS.getMethodName());
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

    public static void queryGoodsInfo() {
        KopGoodsInfoRequest request = new KopGoodsInfoRequest();
        request.setGoodsIds("5245545,8511924,5233404,2767164,2132823,2369789,5247148,1586982,8927565,5296392,1565928,2415029,5249416,8739206,1573169,5971629,10910,5619213,5246545,6192972");
        try {
            String execute = KopUtils.doPost(request, MethodEnum.QUERY_GOODS_INFO.getMethodName());
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

    public static void queryOrderInfo() {
        KopOrderInfoRequest request = new KopOrderInfoRequest();
        request.setType(2);
        request.setStartDate(KopUtils.getMilliSeconds(LocalDateTime.now().minusDays(30)));
        request.setEndDate(KopUtils.getMilliSeconds(LocalDateTime.now()));
        request.setOrderId("10000");
        try {
            String execute = KopUtils.doPost(request, MethodEnum.QUERY_ORDER_INFO.getMethodName());
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

    public static void queryShareLink() {
        KopSelectedGoodsRequest request = new KopSelectedGoodsRequest();
        request.setPoolName("2");
        request.setPageNo(1);
        request.setPageSize(200);
        try {
            String execute = KopUtils.doPost(request, MethodEnum.QUERY_SHARE_LINK.getMethodName());
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

    public static void searchGoods() {
        KopSelectedGoodsRequest request = new KopSelectedGoodsRequest();
        request.setPoolName("2");
        request.setPageNo(1);
        request.setPageSize(200);
        try {
            String execute = KopUtils.doPost(request, MethodEnum.SEARCH_GOODS.getMethodName());
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

    public static void queryActivityInfo() {
        KopSelectedGoodsRequest request = new KopSelectedGoodsRequest();
        request.setPoolName("2");
        request.setPageNo(1);
        request.setPageSize(200);
        try {
            String execute = KopUtils.doPost(request, MethodEnum.QUERY_ACTIVITY_INFO.getMethodName());
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

    public static void queryActivityOrder() {
        KopSelectedGoodsRequest request = new KopSelectedGoodsRequest();
        request.setPoolName("2");
        request.setPageNo(1);
        request.setPageSize(200);
        try {
            String execute = KopUtils.doPost(request, MethodEnum.QUERY_ACTIVITY_ORDER.getMethodName());
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
}
