package com.sdk.kop.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 转链列表
 *
 * @author Administrator
 */
@Data
public class ShareLinkInfo implements Serializable {
    private static final long serialVersionUID = 5021913920215994479L;

    /**
     * 原始链接
     */
    private String originalLink;
    /**
     * 分享链接(原始长链)
     */
    private String shareLink;
    /**
     * 分享短链
     */
    private String shortLink;
}
