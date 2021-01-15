package com.sdk.common.controller;

import com.sdk.common.domain.ChannelInfo;
import com.sdk.config.CategoryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
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
    private CategoryConfig categoryConfig;

    @RequestMapping("/all")
    public List<ChannelInfo> getAllCategory() {
        List<ChannelInfo> allCategory = categoryConfig.getAllCategory();
        return allCategory;
    }

    @RequestMapping("/one/{id}")
    public ChannelInfo getOneCategory(@PathVariable(name = "id", required = true) Integer id) {
        List<ChannelInfo> allCategory = categoryConfig.getAllCategory();
        for (ChannelInfo channelInfo : allCategory) {
            if (id.equals(channelInfo.getChannelId())) {
                return channelInfo;
            }
        }
        return new ChannelInfo();
    }
}
