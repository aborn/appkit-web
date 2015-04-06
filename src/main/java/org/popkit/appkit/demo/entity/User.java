package org.popkit.appkit.demo.entity;

/**
 * @author guobao.jiang
 * @date 3/13/15
 * @time 10:04 AM
 */
public class User {
    private int id;
    private String firstname;
    private String lastname;

    public User() {
    }

    public User(BasicDo basicDo) {
        this.id = basicDo.getId();
        this.firstname = basicDo.getName();
        this.lastname = basicDo.getAddress();
    }

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
