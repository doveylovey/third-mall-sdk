package com.sdk.test.suning;

import com.alibaba.fastjson.JSON;
import com.sdk.suning.client.SuningClientFactory;
import com.sdk.suning.response.MyCommoditydetailQueryResponse;
import com.sdk.suning.response.MySearchcommodityQueryResponse;
import com.suning.api.entity.netalliance.CommoditycategoryQueryRequest;
import com.suning.api.entity.netalliance.CommoditycategoryQueryResponse;
import com.suning.api.entity.netalliance.CommoditydetailQueryRequest;
import com.suning.api.entity.netalliance.CommoditydetailQueryResponse;
import com.suning.api.entity.netalliance.CommodityimagesQueryRequest;
import com.suning.api.entity.netalliance.CommodityimagesQueryResponse;
import com.suning.api.entity.netalliance.CommoditypicsQueryRequest;
import com.suning.api.entity.netalliance.CommoditypicsQueryResponse;
import com.suning.api.entity.netalliance.InverstmentcategoryidQueryRequest;
import com.suning.api.entity.netalliance.InverstmentcategoryidQueryResponse;
import com.suning.api.entity.netalliance.InverstmentcommodityQueryRequest;
import com.suning.api.entity.netalliance.InverstmentcommodityQueryResponse;
import com.suning.api.entity.netalliance.SearchcommodityQueryRequest;
import com.suning.api.entity.netalliance.SearchcommodityQueryResponse;
import com.suning.api.entity.netalliance.SearchcommoditynewQueryRequest;
import com.suning.api.entity.netalliance.SearchcommoditynewQueryResponse;
import com.suning.api.entity.netalliance.UnionInfomationGetRequest;
import com.suning.api.entity.netalliance.UnionInfomationGetResponse;
import com.suning.api.exception.SuningApiException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 苏宁易购商品 API 测试
 *
 * @author Administrator
 */
public class SuningCommodityTests {
    @Test
    public void testCommoditycategoryQuery() {
        // 商品类目查询：根据商品的父类目id，查询子类目id信息，父类目ID和层级都输入1可查询所有一级类目ID
        CommoditycategoryQueryRequest request = new CommoditycategoryQueryRequest();
        CommoditycategoryQueryRequest.CommoditycategoryList commoditycategoryList = new CommoditycategoryQueryRequest.CommoditycategoryList();
        // 父类目ID
        commoditycategoryList.setGrade("2");
        // 查询采购目录层级(1、2、3)
        commoditycategoryList.setParentId("R8231");
        List<CommoditycategoryQueryRequest.CommoditycategoryList> commoditycategoryListList = new ArrayList<>();
        commoditycategoryListList.add(commoditycategoryList);
        request.setCommoditycategoryList(commoditycategoryListList);
        //api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
        request.setCheckParam(true);
        try {
            CommoditycategoryQueryResponse response = SuningClientFactory.getClient().excute(request);
            System.out.println("返回json/xml格式数据 :" + response.getBody());
        } catch (SuningApiException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchcommodityQuery() {
        // 关键字商品查询接口
        SearchcommodityQueryRequest request = new SearchcommodityQueryRequest();
        // 页码，默认为1
        request.setPageIndex("1");
        // 每页条数，默认10，最大支持40
        request.setSize("40");
        // 关键字
        request.setKeyword("iPhone 12");
        // 销售目录ID
        //request.setSaleCategoryCode("R8231");
        // 排序规则：1-综合(默认)、2-销量由高到低、3-价格由高到低、4-价格由低到高、5-佣金比例由高到低、6-佣金金额由高到低、7-两个维度，佣金金额由高到低，销量由高到低、8-近30天推广量由高到低、9-近30天支出佣金金额由高到低
        //request.setSortType("1");
        // 城市编码，默认025
        //request.setCityCode("025");
        // 开始价格
        //request.setStartPrice("10.00");
        // 结束价格
        //request.setEndPrice("20.00");
        // 1-减枝、2-不减枝，sortType=1 (综合)默认不剪枝，其他排序默认剪枝
        //request.setBranch("1");
        // 1-有券、其他-全部
        //request.setCoupon("1");
        // 1-拿到券后价、不传按照以前逻辑取不到券后价
        //request.setCouponMark("1");
        // 是否拼购，默认为空 1：是
        //request.setPgSearch("1");
        // 图片高度，默认200
        //request.setPicHeight("200");
        // 图片宽度，默认200
        //request.setPicWidth("200");
        // 是否苏宁服务：1-是
        //request.setSnfwservice("1");
        // 是否苏宁国际：1-是
        //request.setSnhwg("1");
        // 是否苏宁自营，默认为空：1-是
        //request.setSuningService("1");
        // api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
        request.setCheckParam(true);
        try {
            SearchcommodityQueryResponse response = SuningClientFactory.getClient().excute(request);
            if (response.getBody() != null) {
                MySearchcommodityQueryResponse jsonRootBean = JSON.parseObject(response.getBody(), MySearchcommodityQueryResponse.class);
                System.out.println(jsonRootBean);
            }
            System.out.println("返回json/xml格式数据 :" + response.getBody());
        } catch (SuningApiException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchcommoditynewQuery() {
        // 关键字商品查询接口(新)
        SearchcommoditynewQueryRequest request = new SearchcommoditynewQueryRequest();
        // 页码，默认为1
        request.setPageIndex("1");
        // 每页条数，默认10，最大支持40
        request.setSize("40");
        // 关键字
        request.setKeyword("手机");
        // 销售目录ID
        //request.setSaleCategoryCode("R8231");
        // 排序规则：1-综合(默认)、2-销量由高到低、3-价格由高到低、4-价格由低到高、5-佣金比例由高到低、6-佣金金额由高到低、7-两个维度，佣金金额由高到低，销量由高到低、8-近30天推广量由高到低、9-近30天支出佣金金额由高到低
        //request.setSortType("1");
        // 城市编码，默认025
        //request.setCityCode("025");
        // 开始价格
        //request.setStartPrice("10.00");
        // 结束价格
        //request.setEndPrice("20.00");
        // 1-减枝、2-不减枝，sortType=1 (综合)默认不剪枝，其他排序默认剪枝
        //request.setBranch("1");
        // 1-有券、其他-全部
        //request.setCoupon("1");
        // 是否拼购，默认为空 1：是
        //request.setPgSearch("1");
        // 图片高度，默认200
        //request.setPicHeight("200");
        // 图片宽度，默认200
        //request.setPicWidth("200");
        // 是否苏宁服务：1-是
        //request.setSnfwservice("1");
        // 是否苏宁国际：1-是
        //request.setSnhwg("1");
        // 是否苏宁自营，默认为空：1-是
        //request.setSuningService("1");
        // api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
        request.setCheckParam(true);
        try {
            SearchcommoditynewQueryResponse response = SuningClientFactory.getClient().excute(request);
            System.out.println("返回json/xml格式数据 :" + response.getBody());
        } catch (SuningApiException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCommoditydetailQuery() {
        // 推广商品详情信息接口
        CommoditydetailQueryRequest request = new CommoditydetailQueryRequest();
        //request.setCityCode("025");
        request.setCommodityStr("12122934701-0000000000");
        request.setCouponMark("1");
        request.setPicHeight("750");
        request.setPicWidth("750");
        //api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
        request.setCheckParam(true);
        try {
            CommoditydetailQueryResponse response = SuningClientFactory.getClient().excute(request);
            if(response.getBody() != null){
                MyCommoditydetailQueryResponse myCommoditydetailQueryResponse = JSON.parseObject(response.getBody(), MyCommoditydetailQueryResponse.class);
                System.out.println(myCommoditydetailQueryResponse);
            }
            System.out.println("返回json/xml格式数据 :" + response.getBody());
        } catch (
                SuningApiException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUnionInfomationGet() {
        // 单个查询联盟商品信息
        UnionInfomationGetRequest request = new UnionInfomationGetRequest();
        // 商品 ID
        request.setGoodsCode("12159451122");
        //api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
        request.setCheckParam(true);
        try {
            UnionInfomationGetResponse response = SuningClientFactory.getClient().excute(request);
            System.out.println("返回json/xml格式数据 :" + response.getBody());
        } catch (SuningApiException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInverstmentcategoryidQuery() {
        // 高佣专区类目查询接口
        InverstmentcategoryidQueryRequest request = new InverstmentcategoryidQueryRequest();
        //api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
        request.setCheckParam(true);
        try {
            InverstmentcategoryidQueryResponse response = SuningClientFactory.getClient().excute(request);
            System.out.println("返回json/xml格式数据 :" + response.getBody());
        } catch (SuningApiException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInverstmentcommodityQuery() {
        // 高佣专区商品查询接口
        InverstmentcommodityQueryRequest request = new InverstmentcommodityQueryRequest();
        // 页码，默认为0
        request.setPageIndex("1");
        // 每页条数，默认10
        request.setSize("40");
        // 高佣类目ID，默认为第一个类目
        //request.setCategoryId("C01");
        // 城市编码，默认为025
        //request.setCityCode("025");
        // 图片高度，默认为200
        //request.setPicHeight("200");
        // 图片宽度，默认为200
        //request.setPicWidth("200");
        // 1-拿到券后价、不传按照以前逻辑取不到券后价
        request.setCouponMark("1");
        //api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
        request.setCheckParam(true);
        try {
            InverstmentcommodityQueryResponse response = SuningClientFactory.getClient().excute(request);
            System.out.println("返回json/xml格式数据 :" + response.getBody());
        } catch (SuningApiException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCommoditypicsQuery() {
        // 批量商品图片信息查询接口
        CommoditypicsQueryRequest request = new CommoditypicsQueryRequest();
        List<String> list = new ArrayList<String>() {{
            // 格式为 "商品编号-商家编号"
            add("12154124278-0071173290");
            //add("12154124278");
            //add("11352084046");
        }};
        // 商品集合
        request.setCommodities(String.join(",", list));
        // 图片高度
        //request.setHeight("200");
        // 图片宽度
        //request.setWidth("200");
        //api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
        request.setCheckParam(true);
        try {
            CommoditypicsQueryResponse response = SuningClientFactory.getClient().excute(request);
            System.out.println("返回json/xml格式数据 :" + response.getBody());
        } catch (SuningApiException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCommodityimagesQuery() {
        // 商品图文详情查询
        CommodityimagesQueryRequest request = new CommodityimagesQueryRequest();
        // 商品编码
        request.setCommodityCode("12154124278");
        // 商家编码
        request.setSupplierCode("0071173290");
        // 终端类型
        //request.setTerminalType("0");
        //api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
        request.setCheckParam(true);
        try {
            CommodityimagesQueryResponse response = SuningClientFactory.getClient().excute(request);
            System.out.println("返回json/xml格式数据 :" + response.getBody());
        } catch (SuningApiException e) {
            e.printStackTrace();
        }
    }
}
