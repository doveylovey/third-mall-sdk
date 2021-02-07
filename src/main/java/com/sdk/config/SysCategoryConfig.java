package com.sdk.config;

import com.alibaba.fastjson.JSONArray;
import com.sdk.common.domain.ChannelInfo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 从外部 json 文件中读取商品类目信息
 *
 * @author Administrator
 */
@Slf4j
@Data
@Component
public class SysCategoryConfig {
    @Value("classpath:category.json")
    private Resource resource;
    private StringBuilder readStr;

    public List<ChannelInfo> getAllCategoryList() {
        try {
            if (Objects.isNull(this.readStr)) {
                synchronized (this) {
                    if (Objects.isNull(this.readStr)) {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));
                        this.readStr = new StringBuilder();
                        while (reader.ready()) {
                            this.readStr.append(reader.readLine());
                        }
                    }
                }
            }
            if (Objects.nonNull(this.readStr)) {
                List<ChannelInfo> channel = JSONArray.parseArray(this.readStr.toString(), ChannelInfo.class);
                return channel;
            }
        } catch (Exception e) {
            log.error("读取 category.json 文件异常", e);
        }
        return Collections.EMPTY_LIST;
    }

    public Map<Integer, ChannelInfo> getAllCategoryMap() {
        Map<Integer, ChannelInfo> map = new ConcurrentHashMap<>();
        List<ChannelInfo> list = getAllCategoryList();
        if (list != null && !list.isEmpty()) {
            map = list.stream().collect(Collectors.toMap(ChannelInfo::getChannelId, Function.identity(), (key1, key2) -> key2));
        }
        return map;
    }

    public ChannelInfo getCategoryByChannelId(Integer channelId) {
        ChannelInfo channelInfo = new ChannelInfo();
        Map<Integer, ChannelInfo> map = getAllCategoryMap();
        if (map != null && !map.isEmpty()) {
            channelInfo = map.get(channelId);
        }
        return channelInfo;
    }
}
