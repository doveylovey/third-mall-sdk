package com.sdk.kop.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 转链列表
 *
 * @author Administrator
 */
@Data
public class SearchGoodsLinkInfo implements Serializable {
    private static final long serialVersionUID = 5021913920215994479L;

    /**
     * 页码
     */
    private Integer pageNo;
    /**
     * 页数
     */
    private Integer pageSize;
    /**
     * 总数
     */
    private Integer total;
    /**
     * 搜索结果
     */
    private List<GoodsInfo> dataList;
}
