package org.popkit.appkit.monitor;

/**
 * Created by Aborn Jiang
 * Mail aborn.jiang@gmail.com
 * 2016-05-08:07:39
 */
public class EachLogItem {
    private String time;
    private String log;

    public EachLogItem(String time, String log) {
        this.time = time;
        this.log = log;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
