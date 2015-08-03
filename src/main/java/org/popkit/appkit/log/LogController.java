package org.popkit.appkit.log;

import org.popkit.appkit.common.controller.BaseController;
import org.popkit.appkit.common.entity.ResponseJSON;
import org.popkit.appkit.common.utils.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author guobao.jiang
 * @email guobao.jiang@dianping.com
 * @date 08-03-2015
 * @time 11:20 PM
 */
@Controller
@RequestMapping("/log")
public class LogController extends BaseController {

    @RequestMapping("/demo.html")
    public void demoLog(HttpServletResponse httpResponse) {
        AppKitLog.info("The first log tester!");
        ResponseJSON responseJSON = new ResponseJSON();

        responseJSON.setStatus(ResponseJSON.STATUS_SUCCESS);
        responseJSON.setInfo("get success!");
        ResponseUtils.renderJson(httpResponse, responseJSON.toJSONString());
    }

}
