package com.sdk.taobao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 淘宝类目枚举
 */
@Getter
@AllArgsConstructor
public enum TbCategory {
    /**
     * 聚划算
     */
    JHS("1", 32366),
    /**
     * 天猫满减
     */
    TM_DICOUNT("2", 27160),
    /**
     * 高佣-综合
     */
    GY_ZH("13366", 13366);
    /**
     * 类目编号
     */
    String code;
    /**
     * 类目物料编号
     */
    Integer materialId;

    /**
     * 根据code获取对应精选编码
     *
     * @param code
     * @return
     */
    public static Integer of(String code) {
        TbCategory[] values = TbCategory.values();
        for (TbCategory category : values) {
            if (code.equals(category.getCode())) {
                return category.getMaterialId();
            }
        }
        return null;
    }
}
