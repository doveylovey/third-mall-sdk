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
public class CityCodeInfo implements Serializable {
    private static final long serialVersionUID = 3900506787077097957L;

    /**
     * 城市名称拼音
     */
    private String pinYin;
    /**
     * 参数名称
     */
    private String name;
    /**
     * 参数 id
     */
    private String id;
    /**
     * 城市编码
     */
    private String cityCode;
}
