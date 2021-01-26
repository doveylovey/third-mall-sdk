package com.sdk.suning.controller;

import com.sdk.kop.response.KopRecommendGoodsResponse;
import com.sdk.suning.client.SuningClientFactory;
import com.suning.api.entity.netalliance.InverstmentcategoryidQueryRequest;
import com.suning.api.entity.netalliance.InverstmentcategoryidQueryResponse;
import com.suning.api.exception.SuningApiException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 苏宁易购 api 测试
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/suning")
public class SuningApiController {
    @RequestMapping("/category")
    public Object queryRecommendGoodsList() throws Exception {
        // 高佣专区类目查询接口
        InverstmentcategoryidQueryRequest request = new InverstmentcategoryidQueryRequest();
        //api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
        request.setCheckParam(true);
        try {
            InverstmentcategoryidQueryResponse response = SuningClientFactory.getClient().excute(request);
            System.out.println("返回json/xml格式数据 :" + response.getBody());
            InverstmentcategoryidQueryResponse.SnBody snbody = response.getSnbody();
            InverstmentcategoryidQueryResponse.QueryInverstmentcategoryid queryInverstmentcategoryid = snbody.getQueryInverstmentcategoryid();
            List<InverstmentcategoryidQueryResponse.CategoryList> list = queryInverstmentcategoryid.getCategoryList();
            return list;
        } catch (SuningApiException e) {
            e.printStackTrace();
        }
        return null;
    }

}
