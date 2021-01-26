package com.sdk.suning.client;

import com.suning.api.DefaultSuningClient;

/**
 * 苏宁易购客户端工厂类
 *
 * @author Administrator
 */
public class SuningClientFactory {
    public static class SuningClient {
        static String serverUrl = "https://open.suning.com/api/http/sopRequest";
        static String appKey = "52e1427bd99db46cea6682abc30227df";
        static String appSecret = "cbcdc13b31ea5981e055a533ab01cd13";
        static String format = "json";
        public static DefaultSuningClient client = new DefaultSuningClient(serverUrl, appKey, appSecret, format);
    }

    public static DefaultSuningClient getClient() {
        return SuningClient.client;
    }
}
