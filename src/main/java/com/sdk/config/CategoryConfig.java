package com.sdk.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sdk.common.domain.ChannelInfo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 从外部 json 文件中读取商品类目信息
 *
 * @author Administrator
 */
@Slf4j
@Data
@Component
public class CategoryConfig {
    public static CategoryConfig categoryConfig;
    private StringBuilder categoryStr;
    @Value("classpath:category.json")
    private Resource resource;

    @PostConstruct
    private void init() {
        CategoryConfig.categoryConfig = this;
    }

    public List<ChannelInfo> getAllCategory() {
        try {
            long start = System.currentTimeMillis();
            if (Objects.isNull(categoryStr)) {
                synchronized (this) {
                    if (Objects.isNull(categoryStr)) {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));
                        categoryStr = new StringBuilder();
                        while (reader.ready()) {
                            categoryStr.append(reader.readLine());
                        }
                    }
                }
            }
            long end = System.currentTimeMillis();
            if (log.isDebugEnabled()) {
                log.debug("读取 category.json 消耗时长 {} ms", end - start);
            }
            if (Objects.nonNull(this.categoryStr)) {
                List<ChannelInfo> channel = JSONArray.parseArray(this.categoryStr.toString(), ChannelInfo.class);
                return channel;
            }
        } catch (Exception e) {
            log.error("读取 category.json 文件异常", e);
        }
        return Collections.emptyList();
    }
}
