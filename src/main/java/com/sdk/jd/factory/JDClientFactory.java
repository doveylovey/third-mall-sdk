package com.sdk.jd.factory;

import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;

public class JDClientFactory {
    private static class JDClient {
        private static JdClient jdClient = new DefaultJdClient("https://router.jd.com/api", null, "f56e194559d99cfcfa886d2ec9cb670d", "70b9bc71b92f458aae3dd73c2c2fd75f");
    }

    public static JdClient jdClient() {
        return JDClient.jdClient;
    }
}
