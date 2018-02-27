package org.popkit.appkit.t;

import org.popkit.appkit.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author aborn.jiang
 * @email aborn.jiang@foxmail.com
 * @date 09-27-2015
 * @time 10:36 PM
 */
@Controller
@RequestMapping(value = "/t")
public class TimeController extends BaseController {

    @RequestMapping(value = "house.html")
    public String house() {
        return "t/house";
    }
}
