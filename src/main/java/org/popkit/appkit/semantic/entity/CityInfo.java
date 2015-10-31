package org.popkit.appkit.semantic.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * Author: Aborn Jiang
 * Email : aborn.jiang AT foxmail.com
 * Date  : 10-25-2015
 * Time  : 10:09 AM
 */
public class CityInfo {
    private String cityName;

    private int cityId;

    private String desc;

    public CityInfo(String cityName, int cityId) {
        this(cityName, cityId, " 城市id:" + cityId);
    }

    public CityInfo(String cityName, int cityId, String desc) {
        this.cityName = cityName;
        this.cityId = cityId;
        this.desc = desc;
    }

    public String toJSONString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cityName", cityName);
        jsonObject.put("cityId", cityId);
        return JSONObject.toJSONString(this);
    }

    @Override
    public String toString() {
        return toJSONString();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
