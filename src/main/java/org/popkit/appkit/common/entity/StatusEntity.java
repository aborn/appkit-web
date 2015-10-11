package org.popkit.appkit.common.entity;

/**
 * Author: Aborn Jiang
 * Email : aborn.jiang AT foxmail.com
 * Date  : 10-11-2015
 * Time  : 7:47 PM
 */
public class StatusEntity {
    private boolean success;
    private String msg;

    public StatusEntity(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public static StatusEntity statusSuccess(String msg) {
        return new StatusEntity(true, msg);
    }

    public static StatusEntity statusError(String msg) {
        return new StatusEntity(false, msg);
    }

    @Override
    public String toString() {
        return "StatusEntity{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
