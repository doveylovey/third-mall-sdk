package com.sdk.duomai.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DuoMaiGeneralUrlResponse implements Serializable {


    /**
     * 类型
     * */
    @JSONField(name = "type")
    private String type;

    /**
     * 商品信息
     * */
    @JSONField(name = "product")
    private DuoMaiGeneralUrlProductResponse product;

    /**
     * 计划信息
     * */
    @JSONField(name = "ads")
    private String ads;

    /**
     * 平台
     * */
    @JSONField(name = "platform")
    private String platform;

    /**
     * 长链接
     * */
    @JSONField(name = "url")
    private String url;

    /**
     * 淘口令 部分链接会有
     * */
    @JSONField(name = "code")
    private String code;

    /**
     * 商家原始链接
     * */
    @JSONField(name = "original_link")
    private String originalLink;

    /**
     * 微信小程序page路径
     * */
    @JSONField(name = "product")
    private String wxPath;

    /**
     * 微信小程序appid
     * */
    @JSONField(name = "wx_appid")
    private String wxAppid;

    /**
     * 	微信二维码
     * */
    @JSONField(name = "wx_qrcode")
    private String wxQrcode;

    /**
     * 微信账号原始id
     * */
    @JSONField(name = "wx_ghid")
    private String wxGhid;

    /**
     * deep_link 唤醒链接
     * */
    @JSONField(name = "deep_link")
    private String deepLink;

    /**
     * 	自带短链
     * */
    @JSONField(name = "short_url")
    private String shortUrl;

}
