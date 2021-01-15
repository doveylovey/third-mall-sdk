package com.sdk.common.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 渠道信息
 *
 * @author Administrator
 */
@Data
public class ChannelInfo implements Serializable {
    private static final long serialVersionUID = 3900506787077097957L;

    /**
     * 渠道 id
     */
    private Integer channelId;
    /**
     * 渠道名称
     */
    private String channelName;
    /**
     * 渠道简称
     */
    private String channelShortName;
    /**
     * 该渠道下的所有类目信息
     */
    private List<CategoryInfo> category;
}
