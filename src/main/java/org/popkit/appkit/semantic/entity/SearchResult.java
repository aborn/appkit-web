package org.popkit.appkit.semantic.entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Author: Aborn Jiang
 * Email : aborn.jiang AT foxmail.com
 * Date  : 10-25-2015
 * Time  : 11:09 AM
 */
public class SearchResult<T> {
    private List<T> records;

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        if (CollectionUtils.isNotEmpty(records)) {
            for (T t : records) {
                jsonArray.add(t);
            }
        }
        jsonObject.put("results", jsonArray);
        //jsonObject.put("action", new ActionDo("http://aaaa", "fas"));
        return jsonObject.toJSONString();
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
