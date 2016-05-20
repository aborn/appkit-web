package org.popkit.appkit.gist;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.popkit.appkit.common.log.AppkitLogger;
import org.popkit.appkit.common.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * download gist file
 * exemaple
 * http://localhost:8080/gist/get.json?pkgName=tango-2-theme&url=https://gist.github.com/2024464.git
 * http://appkit.popkit.org/gist/get.json?pkgName=tango-2-theme&url=https://gist.github.com/2024464.git
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
            long lastCommit = GistFetchService.getLastCommiterTime(pkgName);
            jsonObject.put("lastCommit", lastCommit);
            if (lastCommit > 0) {
                jsonObject.put("lastCommitFormat", new SimpleDateFormat("yyyy-MM-dd hh:mm").format(lastCommit));
            }
            jsonObject.put("pkgFile", getPkgFileName(pkgName));
        }
        ResponseUtils.renderJson(response, jsonObject.toJSONString());
    }

    private String getPkgFileName(String pkgName) {
        File pkgPath = new File(GistFetchService.getGistFetchRootPath() + pkgName);
        if (pkgPath.isDirectory()) {
            for (File elispFile : pkgPath.listFiles()) {
                if (elispFile.isFile() && elispFile.getName().endsWith(".el")
                        && (!elispFile.getName().startsWith("."))) {
                    return "/" + pkgPath.getName() + "/" + elispFile.getName();
                }
            }
        }
        return "";
    }

    @RequestMapping(value = "list.json")
    public void list(HttpServletResponse response) {
        List<FetchFile> fetchFileList = new ArrayList<FetchFile>();
        File root = new File(GistFetchService.getGistFetchRootPath());
        if (root.exists() && root.isDirectory()) {
            for (File pkgPath : root.listFiles()) {
                if (pkgPath.isDirectory()) {
                    FetchFile fetchFile = new FetchFile();
                    fetchFile.setPkgName(pkgPath.getName());
                    long lastCommit = GistFetchService.getLastCommiterTime(pkgPath.getName());
                    fetchFile.setLastCommit(lastCommit);
                    if (lastCommit > 0) {
                        fetchFile.setLastCommitFormmatter(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(lastCommit));
                    }

                    for (File elispFile : pkgPath.listFiles()) {
                        if (elispFile.isFile() && elispFile.getName().endsWith(".el")
                                && (!elispFile.getName().startsWith("."))) {
                            fetchFile.setFileName(pkgPath.getName() + "/" + elispFile.getName());
                        }
                    }
                    fetchFileList.add(fetchFile);
                }
            }
        }
        ResponseUtils.renderJson(response, JSON.toJSONString(fetchFileList));
    }

    boolean exists(String pkgName) {
        File file = new File(GistFetchService.getGistFetchRootPath() + pkgName);
        File fileDotGit = new File(GistFetchService.getGistFetchRootPath() + pkgName + "/.git");
        return file.exists() && fileDotGit.exists();
    }
}
