package com.sdk.test.suning;

import com.sdk.suning.client.SuningClientFactory;
import com.suning.api.entity.netalliance.CustompromotionurlQueryRequest;
import com.suning.api.entity.netalliance.CustompromotionurlQueryResponse;
import com.suning.api.exception.SuningApiException;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * 苏宁易购推广链接 API 测试
 *
 * @author Administrator
 */
public class SuningPromotionTests {
    @Test
    public void testCommodityimagesQuery() {
        // 获取自定义推广链接接口
        CustompromotionurlQueryRequest request = new CustompromotionurlQueryRequest();
        // 推广位id，在苏宁联盟会员前台已维护的推广位ID
        request.setAdBookId("0");
        // 子会员码
        request.setSubUser("52");
        // 需要定制的链接(允许定制商品，店铺，频道及活动促销页面，其它页面暂不支持定制)
        request.setVisitUrl("http://product.suning.com/0070517287/12159451122.html");
        //api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
        request.setCheckParam(true);
        try {
            CustompromotionurlQueryResponse response = SuningClientFactory.getClient().excute(request);
            System.out.println("返回json/xml格式数据 :" + response.getBody());
            String extendUrl = response.getSnbody().getQueryCustompromotionurl().getExtendUrl();
            System.out.println("推广链接：" + extendUrl);
            String decodeExtendUrl = URLDecoder.decode(extendUrl, StandardCharsets.UTF_8.name());
            System.out.println("推广链接：" + decodeExtendUrl);

            String shortUrl = response.getSnbody().getQueryCustompromotionurl().getShortUrl();
            System.out.println("推广短链接：" + shortUrl);
            String decodeShortUrl = URLDecoder.decode(shortUrl, StandardCharsets.UTF_8.name());
            System.out.println("推广短链接：" + decodeShortUrl);
        } catch (SuningApiException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
