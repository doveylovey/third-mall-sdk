package com.sdk.test.suning;

import com.alibaba.fastjson.JSON;
import com.sdk.suning.client.SuningClientFactory;
import com.sdk.suning.response.MyOrdersettlenewGetResponse;
import com.suning.api.entity.netalliance.OrderQueryRequest;
import com.suning.api.entity.netalliance.OrderQueryResponse;
import com.suning.api.entity.netalliance.OrdersettlenewGetRequest;
import com.suning.api.entity.netalliance.OrdersettlenewGetResponse;
import com.suning.api.exception.SuningApiException;
import org.junit.Test;

import java.util.List;

/**
 * 苏宁易购推广链接 API 测试
 *
 * @author Administrator
 */
public class SuningOrderTests {
    @Test
    public void testOrderQuery() {
        // 网盟订单信息批量查询
        OrderQueryRequest request = new OrderQueryRequest();
        request.setStartTime("2021-02-05 17:25:00");
        request.setEndTime("2021-02-05 18:25:00");
        request.setPageNo(1);
        request.setPageSize(40);
        request.setOrderLineStatus("0");
        //request.setOrderChannel("14905");
        //request.setPid("qqwwee112233");
        //request.setPromotion("1");
        //api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
        request.setCheckParam(true);
        try {
            OrderQueryResponse response = SuningClientFactory.getClient().excute(request);
            List<OrderQueryResponse.QueryOrder> queryOrder = response.getSnbody().getQueryOrder();
            System.out.println("返回json/xml格式数据 :" + response.getBody());
        } catch (SuningApiException e) {
            e.printStackTrace();
        }
    }

    /*@Test
    public void testOrdersettleGet() {
        OrdersettleGetRequest request = new OrdersettleGetRequest();
        request.setOrderLineNumber("37250383844,37250383844");
        //api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
        request.setCheckParam(true);
        try {
            OrdersettleGetResponse  response = SuningClientFactory.getClient().excute(request);
            System.out.println("返回json/xml格式数据 :" + response.getBody());
        } catch (SuningApiException e) {
            e.printStackTrace();
        }
    }*/

    @Test
    public void testOrdersettlenewGet() {
        OrdersettlenewGetRequest request = new OrdersettlenewGetRequest();
        request.setOrderLineNumber("37250383844");
        //api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
        request.setCheckParam(true);
        try {
            OrdersettlenewGetResponse response = SuningClientFactory.getClient().excute(request);
            if (response.getBody() != null) {
                MyOrdersettlenewGetResponse myOrdersettlenewGet = JSON.parseObject(response.getBody(), MyOrdersettlenewGetResponse.class);
                MyOrdersettlenewGetResponse.GetOrdersettlenew getOrdersettlenew = myOrdersettlenewGet.getSnResponseContent().getSnBody().getGetOrdersettlenew();
                List<MyOrdersettlenewGetResponse.SettlementInfo> settlementInfo = getOrdersettlenew.getSettlementInfo();
                settlementInfo.forEach(System.out::println);
            }
            //System.out.println("返回json/xml格式数据 :" + response.getBody());
        } catch (SuningApiException e) {
            e.printStackTrace();
        }
    }
}
