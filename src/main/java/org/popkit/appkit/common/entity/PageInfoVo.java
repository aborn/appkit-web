package org.popkit.appkit.common.entity;

/**
 * Author: aborn.jiang
 * Email : aborn.jiang AT foxmail.com
 * Date  : 4/6/15
 * Time  : 10:45 AM
 */
public class PageInfoVo {

    private String pageTitle;
    private String pageInfo;
    private int pv;

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(String pageInfo) {
        this.pageInfo = pageInfo;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }
}
