package com.sdk.common.controller;

import com.sdk.common.domain.ChannelInfo;
import com.sdk.config.SysCategoryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private SysCategoryConfig sysCategoryConfig;

    @RequestMapping("/all")
    public List<ChannelInfo> getAllCategory() {
        List<ChannelInfo> allCategory = sysCategoryConfig.getAllCategoryList();
        return allCategory;
    }

    @RequestMapping("/one/{id}")
    public ChannelInfo getOneCategory(@PathVariable(name = "id", required = true) Integer id) {
        //ChannelInfo channelInfo = sysCategoryConfig.getCategoryByChannelId(id);
        List<ChannelInfo> allCategory = sysCategoryConfig.getAllCategoryList();
        for (ChannelInfo channelInfo : allCategory) {
            if (id.equals(channelInfo.getChannelId())) {
                return channelInfo;
            }
        }
        return new ChannelInfo();
    }
}
