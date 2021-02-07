package com.sdk.test.taobao;

import com.alibaba.fastjson.JSON;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsDetailRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsPromotionUrlGenerateRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsDetailResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsPromotionUrlGenerateResponse;
import com.sdk.common.domain.ChannelInfo;
import com.sdk.common.enums.ChannelEnum;
import com.sdk.common.util.AESUtil;
import com.sdk.common.util.SysCategoryInfo;
import com.sdk.pdd.factory.PddClientFactory;
import com.sdk.pdd.request.CustomParameter;
import com.sdk.taobao.enums.TbCategory;
import com.sdk.taobao.factory.TaobaoClientFactory;
import com.taobao.api.ApiException;
import com.taobao.api.request.TbkActivityInfoGetRequest;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkDgOptimusMaterialRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.response.TbkActivityInfoGetResponse;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.TbkDgOptimusMaterialResponse;
import com.taobao.api.response.TbkItemInfoGetResponse;
import com.taobao.api.response.TbkTpwdCreateResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class TaoBaoTests {
    @Test
    public void goodsCategoryList() {
        SysCategoryInfo sysCategoryInfo = new SysCategoryInfo();
        ChannelInfo channelInfo = sysCategoryInfo.getCategoryByChannelId(ChannelEnum.TAO_BAO.getChannelCode());
        System.out.println(channelInfo);
    }

    @Test
    public void goodsList() throws ApiException {
        TbkDgOptimusMaterialRequest request = new TbkDgOptimusMaterialRequest();
        request.setAdzoneId(110799650288L);
        request.setPageNo(1L);
        request.setPageSize(50L);
        Long categoryId = 3788L;
        request.setMaterialId(categoryId);
        TbkDgOptimusMaterialResponse response = TaobaoClientFactory.taobaoClient().execute(request);
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void goodsListByKeyword() throws Exception {
        TbkDgMaterialOptionalRequest request = new TbkDgMaterialOptionalRequest();
        request.setAdzoneId(110799650288L);
        request.setHasCoupon(true);
        request.setPageNo(1L);
        request.setPageSize(50L);
        Long categoryId = null;
        if (categoryId != null) {
            request.setMaterialId(categoryId);
        }
        String keyword = "iPhone 12";
        if (keyword != null) {
            request.setQ(keyword);
        }
        TbkDgMaterialOptionalResponse response = TaobaoClientFactory.taobaoClient().execute(request);
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void goodsById() throws Exception {
        TbkItemInfoGetRequest request = new TbkItemInfoGetRequest();
        request.setNumIids("602441900244");
        TbkItemInfoGetResponse response = TaobaoClientFactory.taobaoClient().execute(request);
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void shareLink() throws Exception {
        // 生成商品普通推广链接
        TbkActivityInfoGetRequest request = new TbkActivityInfoGetRequest();
        request.setAdzoneId(110799650288L);
        String categoryId = "3788";
        //String activityMaterialId = String.valueOf(Long.valueOf(TbCategory.of(categoryId)));
        request.setActivityMaterialId(categoryId);
        request.setUnionId(AESUtil.decryptData("用户标识", "JCdfeCpxtAw2RP45"));
        TbkActivityInfoGetResponse response = TaobaoClientFactory.taobaoClient().execute(request);
        System.out.println("响应结果：" + JSON.toJSONString(response));
    }

    @Test
    public void shareLink2() throws Exception {
        // 生成商品淘口令
        TbkTpwdCreateRequest request = new TbkTpwdCreateRequest();
        // 优惠劵 url
        request.setUrl("https://uland.taobao.com/coupon/edetail?e=4pGIlqKndDkNfLV8niU3R5TgU2jJNKOfNNtsjZw%2F%2FoJ4W4Zoi1cIhJsOzHl6rIbGWmENi4Kvi5xp5TCyT11s3MuRTiT9oEhVZV8pr6FWc0PLLpifGtVR64n7LtZ7ay%2FrmMHpNfYdHdDdiNeO1SSjH3nTUcGrS67J4EWHzXz0RHEB2kqJl2sc4bTYNhSzIv0Kg2faf%2FAvRqEZao0HO%2FvX0w%3D%3D&&app_pvid=59590_11.132.118.149_591_1612682938671&ptl=floorId:3788;app_pvid:59590_11.132.118.149_591_1612682938671;tpp_pvid:c9fce237-f3ff-4fb5-9951-97427029a557&union_lens=lensId%3AMAPI%401612682938%40c9fce237-f3ff-4fb5-9951-97427029a557_634574460160%401");
        // 口令弹框内容
        request.setText("淘口令");
        // 口令弹框 logoURL
        //request.setLogo();
        request.setUserId("用户标识");
        TbkTpwdCreateResponse response = TaobaoClientFactory.taobaoClient().execute(request);
        System.out.println("响应结果：" + JSON.toJSONString(response));
        if (response.isSuccess()) {
            System.out.println("口令描述：" + response.getData().getModel());
            System.out.println("口令：" + response.getData().getPasswordSimple());
        }
    }
}
