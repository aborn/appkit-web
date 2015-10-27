package org.popkit.appkit.common.entity;

/**
 * @author guobao.jiang
 * @date 3/19/15
 * @time 12:31 PM
 */
public class UserInfoVo {
    private String userDomain;

    private int userId;

    private String userName;

    private String logout;

    // 是否为Master用户
    private boolean master;

    public UserInfoVo() {
    }

    public String getUserDomain() {
        return userDomain;
    }

    public void setUserDomain(String userDomain) {
        this.userDomain = userDomain;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogout() {
        return logout;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }
}
