package com.sdk.common.controller;

import com.sdk.common.domain.CityCodeInfo;
import com.sdk.config.SysCityCodeConfig;
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
@RequestMapping("/city-code")
public class CityCodeController {
    @Autowired
    private SysCityCodeConfig sysCityCodeConfig;

    @RequestMapping("/all")
    public List<CityCodeInfo> getAllCityCode() {
        List<CityCodeInfo> allCityCode = sysCityCodeConfig.getAllCityCode();
        return allCityCode;
    }

    @RequestMapping("/id/{id}")
    public CityCodeInfo getCityCodeInfoById(@PathVariable(name = "id", required = true) String id) {
        CityCodeInfo cityCodeInfo = sysCityCodeConfig.getCityCodeInfoById(id);
        return cityCodeInfo;
    }

    @RequestMapping("/name/{name}")
    public CityCodeInfo getCityCodeInfoByName(@PathVariable(name = "name", required = true) String name) {
        CityCodeInfo cityCodeInfo = sysCityCodeConfig.getCityCodeInfoByName(name);
        return cityCodeInfo;
    }

    @RequestMapping("/code/{cityCode}")
    public CityCodeInfo getCityCodeInfoByCityCode(@PathVariable(name = "cityCode", required = true) String cityCode) {
        CityCodeInfo cityCodeInfo = sysCityCodeConfig.getCityCodeInfoByCityCode(cityCode);
        return cityCodeInfo;
    }
}
