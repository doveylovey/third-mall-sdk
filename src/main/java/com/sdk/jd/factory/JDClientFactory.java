package com.sdk.jd.factory;

import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;

public class JDClientFactory {
    private static class JDClient {
        static String serverUrl = "https://router.jd.com/api";
        static String accessToken = null;
        static String appKey = "f56e194559d99cfcfa886d2ec9cb670d";
        static String appSecret = "70b9bc71b92f458aae3dd73c2c2fd75f";
        private static JdClient jdClient = new DefaultJdClient(serverUrl, accessToken, appKey, appSecret);
    }

    public static JdClient jdClient() {
        return JDClient.jdClient;
    }
}
