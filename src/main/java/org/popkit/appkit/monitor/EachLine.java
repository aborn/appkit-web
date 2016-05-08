package org.popkit.appkit.monitor;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by Aborn Jiang
 * Mail aborn.jiang@gmail.com
 * 2016-05-07:22:24
 */
public class EachLine {
    private String label;
    private List<String> labels;
    private List<Integer> data;

    public EachLine(List<String> labels, List<Integer> data) {
        this.labels = labels;
        this.data = data;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
