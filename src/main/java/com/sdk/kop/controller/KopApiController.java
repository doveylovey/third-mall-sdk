package com.sdk.kop.controller;

import com.alibaba.fastjson.JSON;
import com.sdk.kop.constant.KopConstants;
import com.sdk.kop.enums.KopMethodEnum;
import com.sdk.kop.request.*;
import com.sdk.kop.response.*;
import com.sdk.kop.util.KopUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
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
@Slf4j
@RestController
@RequestMapping("/kop")
public class KopApiController {
    @Resource
    private RestTemplate restTemplate;

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
        String url = KopConstants.SERVER + "?" + KopUtils.map2Url(initTreeMap, false);
        ResponseEntity<KopRecommendGoodsResponse> responseEntity = restTemplate.postForEntity(url, null, KopRecommendGoodsResponse.class);
        if (responseEntity != null && HttpStatus.SC_OK == responseEntity.getStatusCode().value()) {
            KopRecommendGoodsResponse response = responseEntity.getBody();
            if (KopConstants.SUCCESS.equals(response.getCode()) && !ObjectUtils.isEmpty(response.getData())) {
                log.info("状态码：{}", response.getCode());
                log.info("信息：{}", response.getMsg());
                log.info("数据：{}", response.getData());
                return response;
            }
        }
        return null;
    }

    @RequestMapping("/querySelectedGoods")
    public KopSelectedGoodsResponse querySelectedGoods() throws Exception {
        KopSelectedGoodsRequest request = new KopSelectedGoodsRequest();
        request.setPoolName("2");
        request.setPageNo(1);
        request.setPageSize(20);
        TreeMap<String, String> initTreeMap = KopUtils.initCommonTreeMap(KopMethodEnum.QUERY_SELECTED_GOODS.getMethodName());
        TreeMap<String, String> requestTreeMap = KopUtils.obj2TreeMap(request);
        initTreeMap.putAll(requestTreeMap);
        String sign = KopUtils.createSign(KopConstants.APPSECRET, initTreeMap);
        initTreeMap.put("sign", sign);
        String url = KopConstants.SERVER + "?" + KopUtils.map2Url(initTreeMap, false);
        ResponseEntity<KopSelectedGoodsResponse> responseEntity = restTemplate.postForEntity(url, null, KopSelectedGoodsResponse.class);
        if (responseEntity != null && HttpStatus.SC_OK == responseEntity.getStatusCode().value()) {
            KopSelectedGoodsResponse response = responseEntity.getBody();
            if (KopConstants.SUCCESS.equals(response.getCode()) && !ObjectUtils.isEmpty(response.getData())) {
                log.info("状态码：{}", response.getCode());
                log.info("信息：{}", response.getMsg());
                log.info("数据：{}", response.getData());
                return response;
            }
        }
        return null;
    }

    @RequestMapping("/queryGoodsInfo")
    public KopGoodsInfoResponse queryGoodsInfo() throws Exception {
        KopGoodsInfoRequest request = new KopGoodsInfoRequest();
        request.setGoodsIds("5245545,8511924,5233404,2767164,2132823,2369789,5247148,1586982,8927565,5296392,1565928,2415029,5249416,8739206,1573169,5971629,10910,5619213,5246545,6192972");
        TreeMap<String, String> initTreeMap = KopUtils.initCommonTreeMap(KopMethodEnum.QUERY_GOODS_INFO.getMethodName());
        TreeMap<String, String> requestTreeMap = KopUtils.obj2TreeMap(request);
        initTreeMap.putAll(requestTreeMap);
        String sign = KopUtils.createSign(KopConstants.APPSECRET, initTreeMap);
        initTreeMap.put("sign", sign);
        String url = KopConstants.SERVER + "?" + KopUtils.map2Url(initTreeMap, false);
        ResponseEntity<KopGoodsInfoResponse> responseEntity = restTemplate.postForEntity(url, null, KopGoodsInfoResponse.class);
        if (responseEntity != null && HttpStatus.SC_OK == responseEntity.getStatusCode().value()) {
            KopGoodsInfoResponse response = responseEntity.getBody();
            if (KopConstants.SUCCESS.equals(response.getCode()) && !ObjectUtils.isEmpty(response.getData())) {
                log.info("状态码：{}", response.getCode());
                log.info("信息：{}", response.getMsg());
                log.info("数据：{}", response.getData());
                return response;
            }
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
        TreeMap<String, String> initTreeMap = KopUtils.initCommonTreeMap(KopMethodEnum.QUERY_ORDER_INFO.getMethodName());
        TreeMap<String, String> requestTreeMap = KopUtils.obj2TreeMap(request);
        initTreeMap.putAll(requestTreeMap);
        String sign = KopUtils.createSign(KopConstants.APPSECRET, initTreeMap);
        initTreeMap.put("sign", sign);
        String url = KopConstants.SERVER + "?" + KopUtils.map2Url(initTreeMap, false);
        ResponseEntity<KopOrderInfoResponse> responseEntity = restTemplate.postForEntity(url, null, KopOrderInfoResponse.class);
        if (responseEntity != null && HttpStatus.SC_OK == responseEntity.getStatusCode().value()) {
            KopOrderInfoResponse response = responseEntity.getBody();
            if (KopConstants.SUCCESS.equals(response.getCode()) && !ObjectUtils.isEmpty(response.getData())) {
                log.info("状态码：{}", response.getCode());
                log.info("信息：{}", response.getMsg());
                log.info("数据：{}", response.getData());
                return response;
            }
        }
        return null;
    }

    @RequestMapping("/queryShareLink")
    public KopShareLinkResponse queryShareLink() throws Exception {
        KopShareLinkRequest request = new KopShareLinkRequest();
        List<String> list = Arrays.asList("https://goods.kaola.com/product/5246545.html", "https://goods.kaola.com/product/8739206.html");
        request.setLinkList(JSON.toJSONString(list));
        TreeMap<String, String> initTreeMap = KopUtils.initCommonTreeMap(KopMethodEnum.QUERY_SHARE_LINK.getMethodName());
        TreeMap<String, String> requestTreeMap = KopUtils.obj2TreeMap(request);
        initTreeMap.putAll(requestTreeMap);
        String sign = KopUtils.createSign(KopConstants.APPSECRET, initTreeMap);
        initTreeMap.put("sign", sign);
        String url = KopConstants.SERVER + "?" + KopUtils.map2Url(initTreeMap, false);
        ResponseEntity<KopShareLinkResponse> responseEntity = restTemplate.postForEntity(url, null, KopShareLinkResponse.class);
        if (responseEntity != null && HttpStatus.SC_OK == responseEntity.getStatusCode().value()) {
            KopShareLinkResponse response = responseEntity.getBody();
            if (KopConstants.SUCCESS.equals(response.getCode()) && !ObjectUtils.isEmpty(response.getData())) {
                log.info("状态码：{}", response.getCode());
                log.info("信息：{}", response.getMsg());
                log.info("数据：{}", response.getData());
                return response;
            }
        }
        return null;
    }

    @RequestMapping("/searchGoods")
    public KopSearchGoodsResponse searchGoods() throws Exception {
        KopSearchGoodsRequest request = new KopSearchGoodsRequest();
        request.setKeyWord("牛仔裤");
        request.setPageNo(1);
        request.setPageSize(20);
        TreeMap<String, String> initTreeMap = KopUtils.initCommonTreeMap(KopMethodEnum.SEARCH_GOODS.getMethodName());
        TreeMap<String, String> requestTreeMap = KopUtils.obj2TreeMap(request);
        initTreeMap.putAll(requestTreeMap);
        String sign = KopUtils.createSign(KopConstants.APPSECRET, initTreeMap);
        initTreeMap.put("sign", sign);
        String url = KopConstants.SERVER + "?" + KopUtils.map2Url(initTreeMap, false);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, null, String.class);
        if (responseEntity != null && HttpStatus.SC_OK == responseEntity.getStatusCode().value()) {
            String body = responseEntity.getBody();
            KopSearchGoodsResponse response = JSON.parseObject(body, KopSearchGoodsResponse.class);
            if (KopConstants.SUCCESS.equals(response.getCode()) && !ObjectUtils.isEmpty(response.getData())) {
                log.info("状态码：{}", response.getCode());
                log.info("信息：{}", response.getMsg());
                log.info("数据：{}", response.getData());
                return response;
            }
        }
        return null;
    }

    @RequestMapping("/queryActivityInfo")
    public KopQueryActivityInfoResponse queryActivityInfo() throws Exception {
        KopQueryActivityInfoRequest request = new KopQueryActivityInfoRequest();
        TreeMap<String, String> initTreeMap = KopUtils.initCommonTreeMap(KopMethodEnum.QUERY_ACTIVITY_INFO.getMethodName());
        TreeMap<String, String> requestTreeMap = KopUtils.obj2TreeMap(request);
        initTreeMap.putAll(requestTreeMap);
        String sign = KopUtils.createSign(KopConstants.APPSECRET, initTreeMap);
        initTreeMap.put("sign", sign);
        String url = KopConstants.SERVER + "?" + KopUtils.map2Url(initTreeMap, false);
        ResponseEntity<KopQueryActivityInfoResponse> responseEntity = restTemplate.postForEntity(url, null, KopQueryActivityInfoResponse.class);
        if (responseEntity != null && HttpStatus.SC_OK == responseEntity.getStatusCode().value()) {
            KopQueryActivityInfoResponse response = responseEntity.getBody();
            if (KopConstants.SUCCESS.equals(response.getCode()) && !ObjectUtils.isEmpty(response.getData())) {
                log.info("状态码：{}", response.getCode());
                log.info("信息：{}", response.getMsg());
                log.info("数据：{}", response.getData());
                return response;
            }
        }
        return null;
    }

    @RequestMapping("/queryActivityOrder")
    public KopQueryActivityOrderResponse queryActivityOrder() throws Exception {
        KopQueryActivityOrderRequest request = new KopQueryActivityOrderRequest();
        request.setActivityId(2);
        TreeMap<String, String> initTreeMap = KopUtils.initCommonTreeMap(KopMethodEnum.QUERY_ACTIVITY_ORDER.getMethodName());
        TreeMap<String, String> requestTreeMap = KopUtils.obj2TreeMap(request);
        initTreeMap.putAll(requestTreeMap);
        String sign = KopUtils.createSign(KopConstants.APPSECRET, initTreeMap);
        initTreeMap.put("sign", sign);
        String url = KopConstants.SERVER + "?" + KopUtils.map2Url(initTreeMap, false);
        ResponseEntity<KopQueryActivityOrderResponse> responseEntity = restTemplate.postForEntity(url, null, KopQueryActivityOrderResponse.class);
        if (responseEntity != null && HttpStatus.SC_OK == responseEntity.getStatusCode().value()) {
            KopQueryActivityOrderResponse response = responseEntity.getBody();
            if (KopConstants.SUCCESS.equals(response.getCode()) && !ObjectUtils.isEmpty(response.getData())) {
                log.info("状态码：{}", response.getCode());
                log.info("信息：{}", response.getMsg());
                log.info("数据：{}", response.getData());
                return response;
            }
        }
        return null;
    }
}
