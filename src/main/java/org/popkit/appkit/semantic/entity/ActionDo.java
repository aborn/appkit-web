package org.popkit.appkit.semantic.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * Author: Aborn Jiang
 * Email : aborn.jiang AT foxmail.com
 * Date  : 10-25-2015
 * Time  : 10:09 AM
 */
public class ActionDo {
    private String url;
    private String text;

    public ActionDo(String url, String text) {
        this.url = url;
        this.text = text;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
