package org.popkit.appkit.gist;

import java.util.Date;

/**
 * Created by Aborn Jiang
 * Mail aborn.jiang@gmail.com
 * 2016-05-20:07:34
 */
public class FetchEvent {
    private Date time;

    public FetchEvent() {
    }

    public FetchEvent(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
