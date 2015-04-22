package org.popkit.appkit.common.controller;

import org.apache.commons.collections.CollectionUtils;
import org.popkit.appkit.demo.entity.User;
import org.popkit.appkit.demo.entity.UserInfoDo;
import org.popkit.appkit.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guobao.jiang
 * @date 3/13/15
 * @time 10:01 AM
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private DemoService demoService;

    /**
     * Static list of users to simulate Database
     */
    private static List<User> userList = new ArrayList<User>();

    // Initialize the list with some data for index screen
    static {
        userList.add(new User("用户名", "地址"));
    }

    /**
     * index.html controller mapper
     *
     * @param model
     * @return The index view (FTL)
     */
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index(@ModelAttribute("model") ModelMap model) {
        List<UserInfoDo> allValues = demoService.queryAllUsersInfo();
        List<User> userListInfo = new ArrayList<User>();

        if (CollectionUtils.isNotEmpty(allValues)) {
            int index = 0;
            for (UserInfoDo item : allValues) {
                userListInfo.add(new User(item));
            }
        }

        for (User item : userList) {
            userListInfo.add(item);
        }

        //model.addAttribute("userList", userListInfo);
        model.addAttribute("pageTitle", "appkit");
        return "/common/index";
    }

    @RequestMapping(value = "/authority/error.html")
    public String authorityError() {
        return "common/no-authority";
    }

}
