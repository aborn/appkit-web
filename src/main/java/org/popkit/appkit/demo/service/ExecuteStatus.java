package org.popkit.appkit.demo.service;

/**
 * Created by Aborn Jiang
 * Mail aborn.jiang@gmail.com
 * 2016-10-30:09:09
 */
public class ExecuteStatus {
    private boolean status;
    private String info;

    public ExecuteStatus(boolean status, String info) {
        this.status = status;
        this.info = info;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
