package com.sdk.duomai.factory;

import com.sdk.duomai.api.CpsOpenApi;

public class DuoMaiClientFactory {
    public static class DuoMaiClient {
        private static CpsOpenApi duoMaiClient = new CpsOpenApi("423944", "a3f3743a7cd6905f3ab66da88c73044a");
    }

    public static CpsOpenApi duoMaiClient() {
        return DuoMaiClient.duoMaiClient;
    }
}
