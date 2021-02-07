package com.sdk.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通道常量接口
 *
 * @author Administrator
 */
@Getter
@AllArgsConstructor
public enum ChannelEnum {
    /**
     * 唯品会
     */
    VOP(1, "vop", "唯品会"),
    /**
     * 淘宝
     */
    TAO_BAO(2, "tb", "淘宝"),
    /**
     * 拼多多
     */
    PDD(3, "pdd", "拼多多"),
    /**
     * 京东
     */
    JD(4, "jd", "京东"),
    /**
     * 考拉海购
     */
    KAO_LA(5, "kaola", "考拉海购"),

    /**
     * 多卖-美团
     */
    DM_MEDIA(6, "dm_media", "美的"),

    /**
     * 多卖-有赞
     */
    DM_YZ(7, "dm_yz", "有赞"),

    /**
     * 苏宁易购
     */
    SU_NING(8, "su_ning", "苏宁易购");

    /**
     * 渠道编号
     */
    Integer channelCode;
    /**
     * 简写
     */
    String channelShortCode;
    /**
     * 渠道名称
     */
    String channelName;

    public static String of(Integer channelCode) {
        for (ChannelEnum channel : ChannelEnum.values()) {
            if (channelCode.equals(channel.getChannelCode())) {
                return channel.getChannelShortCode();
            }
        }
        return null;
    }
}
