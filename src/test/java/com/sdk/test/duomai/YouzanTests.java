package com.sdk.test.duomai;

import com.alibaba.fastjson.JSONObject;
import com.sdk.common.util.AESUtil;
import com.sdk.duomai.api.CpsOpenApi;
import com.sdk.duomai.factory.DuoMaiClientFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class YouzanTests {
    @Test
    public void goodsList() throws IOException {
        String serviceName = "cps-mesh.cpslink.youzan.products.get";
        Map<String, Object> param = new HashMap<>();
        //param.put("id", "");
        //param.put("query", "");
        param.put("page", 1);
        param.put("page_size", 50);
        CpsOpenApi cpsOpenApi = DuoMaiClientFactory.duoMaiClient();
        String res = cpsOpenApi.doReq(serviceName, param);
        System.out.println("响应结果：" + res);
    }

    @Test
    public void goodsListByKeyword() throws IOException {
        String serviceName = "cps-mesh.cpslink.youzan.products.get";
        Map<String, Object> param = new HashMap<>();
        param.put("query", "手机");
        param.put("page", 1);
        param.put("page_size", 50);
        CpsOpenApi cpsOpenApi = DuoMaiClientFactory.duoMaiClient();
        String res = cpsOpenApi.doReq(serviceName, param);
        System.out.println("响应结果：" + res);
    }

    @Test
    public void goodsById() throws IOException {
        String serviceName = "cps-mesh.cpslink.youzan.products.get";
        Map<String, Object> param = new HashMap<>();
        param.put("id", "1000000000100511267046");
        CpsOpenApi cpsOpenApi = DuoMaiClientFactory.duoMaiClient();
        String res = cpsOpenApi.doReq(serviceName, param);
        System.out.println("响应结果：" + res);
    }

    @Test
    public void shareLink() throws Exception {
        String serviceName="cps-mesh.cpslink.links.post";
        String goodsDetailServiceName="cps-mesh.cpslink.youzan.products.detail";
        Map<String, Object> param = new HashMap<>();
        param.put("id", "1000000000100511267046");
        CpsOpenApi cpsOpenApi = DuoMaiClientFactory.duoMaiClient();
        String res = cpsOpenApi.doReq(goodsDetailServiceName, param);
        System.out.println("响应结果1：" + res);
        param.clear();

        // 取出上一步中的 item_url 传入
        String item_url = "";
        param.put("ads_id", "2214");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("euid", AESUtil.encryptData("用户标识", AESUtil.IV) + "M");
        param.put("ext", jsonObject);
        param.put("url", item_url);
        param.put("site_id", 423944);
        res = cpsOpenApi.doReq(serviceName, param);
        System.out.println("响应结果2：" + res);
    }
}
