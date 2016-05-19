package org.popkit.appkit.gist;

import com.alibaba.fastjson.JSONObject;
import org.popkit.appkit.common.log.AppkitLogger;
import org.popkit.appkit.common.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by Aborn Jiang
 * Mail aborn.jiang@gmail.com
 * 2016-05-20:06:57
 */
@Controller
@RequestMapping(value = "gist")
public class GistController {

    @Autowired
    private GistFetchService fetchService;

    @RequestMapping(value = "get.json")
    public void get(HttpServletResponse response,
                    String pkgName, String url) {
        AppkitLogger.info("pkgName=" + pkgName);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "failed");
        if (StringUtils.isEmpty(pkgName) ||StringUtils.isEmpty(url)) {
            jsonObject.put("info", "parameter (pkgName or url) empty");
        } else if (!exists(pkgName)) {
            jsonObject.put("info", "not fetched!");
            fetchService.fetch(pkgName, url);
        } else {
            jsonObject.put("status", "success");
            jsonObject.put("info", "success");
            fetchService.fetch(pkgName, url);
        }
        ResponseUtils.renderJson(response, jsonObject.toJSONString());
    }

    boolean exists(String pkgName) {
        File file = new File(GistFetchService.getGistFetchRootPath() + pkgName);
        File fileDotGit = new File(GistFetchService.getGistFetchRootPath() + pkgName + "/.git");
        return file.exists() && fileDotGit.exists();
    }
}
