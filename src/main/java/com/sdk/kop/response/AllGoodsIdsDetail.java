package com.sdk.kop.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品基础信息
 *
 * @author Administrator
 */
@Data
public class AllGoodsIdsDetail implements Serializable {
    private static final long serialVersionUID = -5220313683960882349L;

    /**
     * 最后一个商品 ID，下次调用时传参，如果所有商品返回完毕，则返回 -1
     */
    private Long flag;
    /**
     * 商品 ID 列表
     */
    private List<Long> goodsIds;
}
