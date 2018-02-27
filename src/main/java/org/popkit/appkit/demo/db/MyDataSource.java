package org.popkit.appkit.demo.db;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * @author Aborn Jiang
 * @email aborn.jiang@foxmail.com
 * Date  : 02-27-2018
 * Time  : 11:44 AM
 */
public class MyDataSource extends BasicDataSource implements InitializingBean {

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String url = this.getUrl();
        // 下面设置具体的值
        if (StringUtils.isBlank(url)) {
            this.setUrl("");
        }
        String username = this.getUsername();
        if (StringUtils.isBlank(username)) {
            this.setUsername("");
        }
        String password = this.getPassword();
        if (StringUtils.isBlank(password)) {
            this.setPassword("");
        }
    }
}
