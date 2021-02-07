package com.sdk.pdd.factory;

import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;

public class PddClientFactory {
    public static class PddClient {
        static String apiServerUrl = "https://gw-api.pinduoduo.com/api/router";
        static String clientId = "15d4c6adb15b48d79d5e359d734a8b49";
        static String clientSecret = "287c67cc83ea8b14e40b8789f98f9c960891a33d";
        public static PopClient popClient = new PopHttpClient(apiServerUrl, clientId, clientSecret);
    }

    public static PopClient popClient() {
        return PddClient.popClient;
    }
}
