package com.sdk.duomai.factory;

import com.sdk.duomai.api.CpsOpenApi;

public class DuoMaiClientFactory {
    public static class DuoMaiClient {
        static String appKey = "423944";
        static String appSecret = "a3f3743a7cd6905f3ab66da88c73044a";
        private static CpsOpenApi duoMaiClient = new CpsOpenApi(appKey, appSecret);
    }

    public static CpsOpenApi duoMaiClient() {
        return DuoMaiClient.duoMaiClient;
    }
}
