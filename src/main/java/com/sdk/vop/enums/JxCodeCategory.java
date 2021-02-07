package com.sdk.vop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JxCodeCategory {
    /**
     * 女装精选
     */
    WOMEN_JX("1", "7hfpy0m4"),
    /**
     * 男装精选
     */
    WOMAN_JX("2", "wj7evz2j"),
    /**
     * 美妆精装
     */
    BEAUTY_JX("3", "vd0wbfdx"),
    /**
     * 数码精选
     */
    DIGITAL_JX("4", "dpot8m5u"),
    /**
     * 首饰精装
     */
    JEWELRY_JX("5", "szkl4kj7"),
    /**
     * 鞋包精选
     */
    SHOE_JX("6", "byh9331t"),
    /**
     * 母婴精装
     */
    BODY_JX("7", "gkf52p8p"),
    /**
     * 居家精选
     */
    HOME_JX("8", "cnrzcs22"),
    /**
     * 运动户外精选
     */
    OUT_DOOR_JX("9", "indvf44e"),
    /**
     * 家用电器
     */
    HOME_APPLIACTION_JX("10", "uggxpyh5");
    /**
     * 编号
     */
    private String code;
    /**
     * 特定商品编码
     */
    private String jxCode;

    /**
     * 根据code获取对应精选编码
     *
     * @param code
     * @return
     */
    public static String of(String code) {
        JxCodeCategory[] values = JxCodeCategory.values();
        for (JxCodeCategory category : values) {
            if (code.equals(category.getCode())) {
                return category.getJxCode();
            }
        }
        return null;
    }
}
