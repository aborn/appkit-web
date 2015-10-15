package org.popkit.appkit.demo.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Aborn Jiang
 * @email aborn.jiang AT foxmail.com
 * @date 07-13-2015
 * @time 4:10 PM
 */
public class FileInfo {
    private String name;
    private String size;
    private String url;
    private String thumbnailUrl;
    private String deleteUrl;
    private String deleteType;

    private String error;

    // 下面两个字段不需要返回
    private String type;
    private byte[] bytes;


    @Override
    public String toString() {
        return toJSONString();
    }

    public String toJSONString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("size", size);
        jsonObject.put("url", url);
        jsonObject.put("thumbnailUrl", thumbnailUrl);
        jsonObject.put("deleteUrl", deleteUrl);
        jsonObject.put("deleteType", deleteType);
        return jsonObject.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
    }

    public String getDeleteType() {
        return deleteType;
    }

    public void setDeleteType(String deleteType) {
        this.deleteType = deleteType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
