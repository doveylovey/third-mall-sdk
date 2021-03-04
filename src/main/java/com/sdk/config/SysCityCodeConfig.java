package com.sdk.config;

import com.alibaba.fastjson.JSONArray;
import com.sdk.common.domain.CityCodeInfo;
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
 * 从外部 json 文件中读取城市编码信息
 *
 * @author Administrator
 */
@Slf4j
@Data
@Component
public class SysCityCodeConfig {
    @Value("classpath:city-code.json")
    private Resource resource;
    private StringBuilder readStr;

    public List<CityCodeInfo> getAllCityCode() {
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
                List<CityCodeInfo> cityCodeInfoList = JSONArray.parseArray(this.readStr.toString(), CityCodeInfo.class);
                return cityCodeInfoList;
            }
        } catch (Exception e) {
            log.error("读取 city-code.json 文件异常", e);
        }
        return Collections.EMPTY_LIST;
    }

    public Map<String, CityCodeInfo> id2InfoMap() {
        List<CityCodeInfo> allCityCodeList = getAllCityCode();
        if (allCityCodeList != null && !allCityCodeList.isEmpty()) {
            return allCityCodeList.stream().collect(Collectors.toMap(CityCodeInfo::getId, Function.identity(), (key1, key2) -> key2));
        }
        return Collections.EMPTY_MAP;
    }

    public CityCodeInfo getCityCodeInfoById(String id) {
        CityCodeInfo cityCodeInfo = new CityCodeInfo();
        Map<String, CityCodeInfo> map = id2InfoMap();
        if (map != null && !map.isEmpty()) {
            cityCodeInfo = map.get(id);
        }
        return cityCodeInfo;
    }

    public Map<String, CityCodeInfo> name2InfoMap() {
        List<CityCodeInfo> allCityCodeList = getAllCityCode();
        if (allCityCodeList != null && !allCityCodeList.isEmpty()) {
            return allCityCodeList.stream().collect(Collectors.toMap(CityCodeInfo::getName, Function.identity(), (key1, key2) -> key2));
        }
        return Collections.EMPTY_MAP;
    }

    public CityCodeInfo getCityCodeInfoByName(String name) {
        CityCodeInfo cityCodeInfo = new CityCodeInfo();
        Map<String, CityCodeInfo> map = name2InfoMap();
        if (map != null && !map.isEmpty()) {
            cityCodeInfo = map.get(name);
        }
        return cityCodeInfo;
    }

    public Map<String, CityCodeInfo> cityCode2InfoMap() {
        List<CityCodeInfo> allCityCodeList = getAllCityCode();
        if (allCityCodeList != null && !allCityCodeList.isEmpty()) {
            return allCityCodeList.stream().collect(Collectors.toMap(CityCodeInfo::getCityCode, Function.identity(), (key1, key2) -> key2));
        }
        return Collections.EMPTY_MAP;
    }

    public CityCodeInfo getCityCodeInfoByCityCode(String cityCode) {
        CityCodeInfo cityCodeInfo = new CityCodeInfo();
        Map<String, CityCodeInfo> map = cityCode2InfoMap();
        if (map != null && !map.isEmpty()) {
            cityCodeInfo = map.get(cityCode);
        }
        return cityCodeInfo;
    }
}
