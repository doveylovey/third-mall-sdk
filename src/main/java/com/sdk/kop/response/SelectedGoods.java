package com.sdk.kop.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 精选商品信息
 *
 * @author Administrator
 */
@Data
public class SelectedGoods implements Serializable {
    private static final long serialVersionUID = -2025131831775382152L;

    /**
     * 总记录数
     */
    private Integer totalRecord;
    /**
     * 页码
     */
    private Integer pageNo;
    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 商品 Id
     */
    private List<Long> goodsIdList;
}
