package com.sdk.kop.controller;

import com.alibaba.fastjson.JSON;
import com.sdk.kop.constant.KopConstants;
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
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/kop")
public class KopApiController {
    @Resource
    private RestTemplate kopClient;

    @RequestMapping("/queryRecommendGoodsList")
    public KopRecommendGoodsResponse queryRecommendGoodsList() throws Exception {
        KopRecommendGoodsRequest request = new KopRecommendGoodsRequest();
        request.setSortType(1);
        request.setPageIndex(1);
        request.setPageSize(20);
        TreeMap<String, String> initTreeMap = KopUtils.initCommonTreeMap(KopMethodEnum.QUERY_RECOMMEND_GOODS_LIST.getMethodName());
        TreeMap<String, String> requestTreeMap = KopUtils.obj2TreeMap(request);
        initTreeMap.putAll(requestTreeMap);
        String sign = KopUtils.createSign(KopConstants.APPSECRET, initTreeMap);
        initTreeMap.put("sign", sign);
        String url = KopConstants.SERVER + "?" + KopUtils.map2Url(initTreeMap);
        System.out.println("请求地址：" + url);
        ResponseEntity<KopRecommendGoodsResponse> responseEntity = kopClient.postForEntity(url, null, KopRecommendGoodsResponse.class);
        if (responseEntity != null && HttpStatus.SC_OK == responseEntity.getStatusCode().value()) {
            KopRecommendGoodsResponse response = responseEntity.getBody();
            System.out.println("结果：" + JSON.toJSONString(response));
            System.out.println("状态码：" + response.getCode());
            System.out.println("信息：" + response.getMsg());
            System.out.println("数据：" + response.getData());
            return response;
        }
        return null;
    }

    @RequestMapping("/querySelectedGoods")
    public KopSelectedGoodsResponse querySelectedGoods() throws Exception {
        KopSelectedGoodsRequest request = new KopSelectedGoodsRequest();
        request.setPoolName("2");
        request.setPageNo(1);
        request.setPageSize(20);
        String execute = KopUtils.doPost(request, KopMethodEnum.QUERY_SELECTED_GOODS.getMethodName());
        if (execute != null && !"".equals(execute.trim())) {
            KopSelectedGoodsResponse response = JSON.parseObject(execute, KopSelectedGoodsResponse.class);
            System.out.println("结果：" + JSON.toJSONString(response));
            System.out.println("状态码：" + response.getCode());
            System.out.println("信息：" + response.getMsg());
            System.out.println("数据1：" + response.getData());
            System.out.println("数据2：" + response.getData().getGoodsIdList());
            return response;
        }
        return null;
    }

    @RequestMapping("/queryGoodsInfo")
    public KopGoodsInfoResponse queryGoodsInfo() throws Exception {
        KopGoodsInfoRequest request = new KopGoodsInfoRequest();
        request.setGoodsIds("5245545,8511924,5233404,2767164,2132823,2369789,5247148,1586982,8927565,5296392,1565928,2415029,5249416,8739206,1573169,5971629,10910,5619213,5246545,6192972");
        String execute = KopUtils.doPost(request, KopMethodEnum.QUERY_GOODS_INFO.getMethodName());
        if (execute != null && !"".equals(execute.trim())) {
            KopGoodsInfoResponse response = JSON.parseObject(execute, KopGoodsInfoResponse.class);
            //System.out.println("结果：" + JSON.toJSONString(response));
            System.out.println("状态码：" + response.getCode());
            System.out.println("信息：" + response.getMsg());
            System.out.println("数据：");
            response.getData().forEach(System.out::println);
            return response;
        }
        return null;
    }

    @RequestMapping("/queryOrderInfo")
    public KopOrderInfoResponse queryOrderInfo() throws Exception {
        KopOrderInfoRequest request = new KopOrderInfoRequest();
        request.setType(2);
        request.setStartDate(KopUtils.getMilliSeconds(LocalDateTime.now().minusDays(30)));
        request.setEndDate(KopUtils.getMilliSeconds(LocalDateTime.now()));
        request.setOrderId("10000");
        String execute = KopUtils.doPost(request, KopMethodEnum.QUERY_ORDER_INFO.getMethodName());
        if (execute != null && !"".equals(execute.trim())) {
            KopOrderInfoResponse response = JSON.parseObject(execute, KopOrderInfoResponse.class);
            System.out.println("结果：" + JSON.toJSONString(response));
            System.out.println("状态码：" + response.getCode());
            System.out.println("信息：" + response.getMsg());
            System.out.println("数据：" + response.getData());
            return response;
        }
        return null;
    }

    @RequestMapping("/queryShareLink")
    public KopShareLinkResponse queryShareLink() throws Exception {
        KopShareLinkRequest request = new KopShareLinkRequest();
        List<String> list = Arrays.asList("https://goods.kaola.com/product/5246545.html", "https://goods.kaola.com/product/8739206.html");
        request.setLinkList(JSON.toJSONString(list));
        String execute = KopUtils.doPost(request, KopMethodEnum.QUERY_SHARE_LINK.getMethodName());
        if (execute != null && !"".equals(execute.trim())) {
            KopShareLinkResponse response = JSON.parseObject(execute, KopShareLinkResponse.class);
            System.out.println("结果：" + JSON.toJSONString(response));
            System.out.println("状态码：" + response.getCode());
            System.out.println("信息：" + response.getMsg());
            System.out.println("数据：" + response.getData());
            return response;
        }
        return null;
    }

    @RequestMapping("/searchGoods")
    public KopSearchGoodsResponse searchGoods() throws Exception {
        KopSearchGoodsRequest request = new KopSearchGoodsRequest();
        request.setKeyWord("iPhone 12 Pro Max");
        request.setPageNo(1);
        request.setPageSize(20);
        TreeMap<String, String> initTreeMap = KopUtils.initCommonTreeMap(KopMethodEnum.SEARCH_GOODS.getMethodName());
        TreeMap<String, String> requestTreeMap = KopUtils.obj2TreeMap(request);
        initTreeMap.putAll(requestTreeMap);
        String sign = KopUtils.createSign(KopConstants.APPSECRET, initTreeMap);
        initTreeMap.put("sign", sign);
        String url = KopConstants.SERVER + "?" + KopUtils.map2Url(initTreeMap);
        System.out.println("请求地址：" + url);
        ResponseEntity<KopSearchGoodsResponse> responseEntity = kopClient.postForEntity(url, null, KopSearchGoodsResponse.class);
        if (responseEntity != null && HttpStatus.SC_OK == responseEntity.getStatusCode().value()) {
            KopSearchGoodsResponse response = responseEntity.getBody();
            System.out.println("结果：" + JSON.toJSONString(response));
            System.out.println("状态码：" + response.getCode());
            System.out.println("信息：" + response.getMsg());
            System.out.println("数据：" + response.getData());
            return response;
        }
        return null;
    }

    @RequestMapping("/queryActivityInfo")
    public KopQueryActivityInfoResponse queryActivityInfo() throws Exception {
        KopQueryActivityInfoRequest request = new KopQueryActivityInfoRequest();
        String execute = KopUtils.doPost(request, KopMethodEnum.QUERY_ACTIVITY_INFO.getMethodName());
        if (execute != null && !"".equals(execute.trim())) {
            KopQueryActivityInfoResponse response = JSON.parseObject(execute, KopQueryActivityInfoResponse.class);
            System.out.println("结果：" + JSON.toJSONString(response));
            System.out.println("状态码：" + response.getCode());
            System.out.println("信息：" + response.getMsg());
            System.out.println("数据：" + response.getData());
            return response;
        }
        return null;
    }

    @RequestMapping("/queryActivityOrder")
    public KopQueryActivityOrderResponse queryActivityOrder() throws Exception {
        KopQueryActivityOrderRequest request = new KopQueryActivityOrderRequest();
        request.setActivityId(2);
        String execute = KopUtils.doPost(request, KopMethodEnum.QUERY_ACTIVITY_ORDER.getMethodName());
        if (execute != null && !"".equals(execute.trim())) {
            KopQueryActivityOrderResponse response = JSON.parseObject(execute, KopQueryActivityOrderResponse.class);
            System.out.println("结果：" + JSON.toJSONString(response));
            System.out.println("状态码：" + response.getCode());
            System.out.println("信息：" + response.getMsg());
            System.out.println("数据：" + response.getData());
            return response;
        }
        return null;
    }
}
