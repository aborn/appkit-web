package org.popkit.appkit.monitor;

import org.popkit.appkit.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Aborn Jiang
 * Mail aborn.jiang@gmail.com
 * 2016-05-07:21:34
 */
@Controller
@RequestMapping(value = "monitor")
public class MonitorController extends BaseController {

    @RequestMapping(value = "ss.html")
    public String ss() {
        return "monitor/ss-monitor";
    }

}
