package org.popkit.appkit.demo.entity;

/**
 * @author guobao.jiang
 * @date 3/15/15
 * @time 4:05 PM
 */
public class BasicDo {
    private Integer id;
    private String name;
    private String address;

    public BasicDo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BasicDo(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
