package com.sdk.kop.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 批量转链接口请求参数封装
 *
 * @author Administrator
 */
@Data
public class KopShareLinkRequest implements Serializable {
    private static final long serialVersionUID = -991985813689656508L;

    /**
     * 非必须。渠道参数1
     */
    private String trackingCode1;
    /**
     * 非必须。渠道参数2
     */
    private String trackingCode2;
    /**
     * 必须。需要转链的链接，必须是考拉链接。List<String> 转 JSON 传输
     */
    private String linkList;
}
