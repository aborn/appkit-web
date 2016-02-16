package org.popkit.appkit.common.controller;

import org.apache.commons.lang.StringUtils;
import org.popkit.appkit.common.entity.PageInfoVo;
import org.popkit.appkit.common.entity.UserInfoVo;
import org.popkit.appkit.demo.entity.UserInfoDo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * The basic controller, all other controller will
 *   inherit it, keep common info, like login user info.
 *
 * Author: aborn.jiang
 * Email : aborn.jiang AT foxmail.com
 * Date  : 4/6/15
 * Time  : 10:40 AM
 */
@Controller
public class BaseController {
    public static int pv = 0;

    @ModelAttribute
    public void initPageParams(@ModelAttribute("page")PageInfoVo pageInfoVo) {
        pageInfoVo.setPageTitle("appkit-web");
        pageInfoVo.setPageInfo("appkit-web");
        pageInfoVo.setPv(BaseController.pv);
    }

    public UserInfoDo getUserInfo() {
        UserInfoDo userInfoDo = new UserInfoDo();
        userInfoDo.setName("Aborn Jiang");
        return userInfoDo;
    }

    /**
     * 获得用户相关的信息
     * @param userInfo 返回给view层的登录用户信息
     */
    @ModelAttribute
    public void initUserInfo(@ModelAttribute("userInfo") UserInfoVo userInfo) {
        UserInfoDo userInfoDoLogin = this.getUserInfo();
        String logout = "/logout.html";
        logout = StringUtils.isBlank(logout) ? "#" : logout;
        userInfo.setUserName(userInfoDoLogin.getName());
    }
}
