package org.popkit.appkit.kit;

import org.popkit.appkit.common.controller.BaseController;
import org.popkit.appkit.common.entity.ResponseJSON;
import org.popkit.appkit.common.utils.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author guobao.jiang
 * @email guobao.jiang@dianping.com
 * @date 09-30-2015
 * @time 2:22 PM
 */
@RequestMapping(value = "/kit")
@Controller
public class KitController extends BaseController {

    private enum NetType {
        CHINANET,
        GFWLIST
    }

    @RequestMapping(value = "/chinanet.txt")
    public void chinaNetTxt(HttpServletRequest request, HttpServletResponse response) {
        update(response, NetType.CHINANET);
    }

    private void update(HttpServletResponse response, NetType netType) {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        String filePathName = getFilePathName(netType);

        try {
            com.google.common.io.Files.copy(new File(filePathName), response.getOutputStream());
        } catch (IOException e) {
            ResponseUtils.renderJson(response, ResponseJSON.getFailedResponse("异常").toJSONString());
        } finally {
            // do nothing
        }
    }

    private String getFilePathName(NetType netType) {
        Map<String, String> env = System.getenv();
        String root = env.get("HOME");
        switch (netType) {
            case CHINANET : return root + "/github/popkit/switchysharp/chinanet.txt";
            case GFWLIST : return root + "/github/popkit/switchysharp/gfwlist.txt";
        }

        return  root + "/github/popkit/switchysharp/gfwlist.txt";
    }

    @RequestMapping(value = "/gfwlist.txt")
    private void  gfw(HttpServletResponse response) {
        update(response, NetType.GFWLIST);
    }
}
