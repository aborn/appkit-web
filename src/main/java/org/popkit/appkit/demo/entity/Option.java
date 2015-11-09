package org.popkit.appkit.demo.entity;

public class Option {

    public Option() {
    }

    public Option(Object value, Object desc) {
        this.value = value.toString();
        this.desc = desc.toString();
    }

    private String value;

    private String desc;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
