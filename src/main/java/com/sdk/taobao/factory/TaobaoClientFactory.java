package com.sdk.taobao.factory;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;

public class TaobaoClientFactory {
    public static class TbClient {
        // http://gw.api.taobao.com/router/rest
        // https://eco.taobao.com/router/rest
        static String serverUrl = "http://gw.api.taobao.com/router/rest";
        static String appKey = "31118424";
        static String appSecret = "0aeb6b52a69e42492861829003e3f209";

        static TaobaoClient taobaoClient = new DefaultTaobaoClient(serverUrl, appKey, appSecret);
    }

    public static TaobaoClient taobaoClient() {
        return TbClient.taobaoClient;
    }
}
