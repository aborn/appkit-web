package org.popkit.appkit.common.controller;

import org.popkit.appkit.common.entity.PageInfoVo;
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
}
