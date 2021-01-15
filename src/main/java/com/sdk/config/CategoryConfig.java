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
    @Value("classpath:category.json")
    private Resource resource;
    private StringBuilder readStr;

    public List<ChannelInfo> getAllCategory() {
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
}
