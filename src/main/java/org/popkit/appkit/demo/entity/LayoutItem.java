package org.popkit.appkit.demo.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * Author: Aborn Jiang
 * Email : aborn.jiang AT foxmail.com
 * Date  : 11-09-2015
 * Time  : 4:47 PM
 */
public class LayoutItem {
    private int col;
    private int row;
    private int size_x;
    private int size_y;
    private int order;

    public LayoutItem(JSONObject jsonObject) {
        this.col = jsonObject.getInteger("col");
        this.row = jsonObject.getInteger("row");
        this.size_x = jsonObject.getInteger("size_x");
        this.size_y = jsonObject.getInteger("size_y");
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSize_x() {
        return size_x;
    }

    public void setSize_x(int size_x) {
        this.size_x = size_x;
    }

    public int getSize_y() {
        return size_y;
    }

    public void setSize_y(int size_y) {
        this.size_y = size_y;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
