package org.popkit.appkit.log;

import org.apache.commons.lang.StringUtils;
import org.popkit.appkit.common.controller.BaseController;
import org.popkit.appkit.common.entity.ResponseJSON;
import org.popkit.appkit.common.utils.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author aborn.jiang
 * @email aborn.jiang@foxmail.com
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

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        AppKitLog.info("TIME:" + simpleDateFormat.format(date) + " ");

        responseJSON.setStatus(ResponseJSON.STATUS_SUCCESS);
        responseJSON.setInfo("get success!");
        ResponseUtils.renderJson(httpResponse, responseJSON.toJSONString());
    }

    @RequestMapping("/show.html")
    public void showLog(HttpServletResponse response) {
        // 页面展示
        String fileName = "appkit.log";
        String filePathName = "/data/applogs/appkit-web/" + fileName;
        try {
            String contentType = getContentType(fileName);
            response.setContentType(contentType);
            com.google.common.io.Files.copy(new File(filePathName), response.getOutputStream());
        } catch (IOException e) {
            ResponseUtils.renderJson(response, ResponseJSON.getFailedResponse("异常").toJSONString());
        }
    }


    public String getContentType(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            return "";
        }

        if (fileName.endsWith(".gif")) {
            return "image/gif";
        } else if (fileName.endsWith(".jpeg") || fileName.endsWith(".jpg")) {
            return "image/jpg";
        } else if (fileName.endsWith(".png")) {
            return "image/png";
        } else if (fileName.endsWith(".json")) {
            return "application/json";
        } else if (fileName.endsWith(".txt") || fileName.endsWith(".text")
                || fileName.endsWith(".log")) {
            return "text/plain";
        }

        return "";
    }
}
