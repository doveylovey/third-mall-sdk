package com.sdk.kop.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 考拉赚客公用请求参数
 *
 * @author Administrator
 */
@Data
public class KopBaseRequest implements Serializable {
    private static final long serialVersionUID = 8171998467591581485L;

    /**
     * 必填。时间戳，格式为 yyyy-MM-dd HH:mm:ss。
     * 例如：2013-05-06 13:52:03。考拉 API 服务端允许客 户端请求时间误 差为 6 分钟
     */
    private String timestamp;
    /**
     * 必填。API 协议版本，可选值：1.0
     */
    private String v;
    /**
     * 必填。对 API 调用参数(除 sign 外)进行 md5 加密获得
     */
    private String sign;
    /**
     * 必填。参数的加密方法选择，可选值：md5
     */
    private String signMethod;
    /**
     * 必填。赚客 ID。例如：zhuanke_5464
     */
    private String unionId;
    /**
     * 必填。需要调用的方法全路径名称
     */
    private String method;
}
