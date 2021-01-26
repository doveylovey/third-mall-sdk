package com.sdk.test.suning;

import com.sdk.suning.client.SuningClientFactory;
import com.suning.api.DefaultSuningClient;
import com.suning.api.entity.netalliance.InverstmentcategoryidQueryRequest;
import com.suning.api.entity.netalliance.InverstmentcategoryidQueryResponse;
import com.suning.api.exception.SuningApiException;
import org.junit.Test;

/**
 * @author Administrator
 */
public class SuningTests {
    @Test
    public void test() {
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
}
