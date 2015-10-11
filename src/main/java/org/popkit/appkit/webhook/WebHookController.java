package org.popkit.appkit.webhook;

import com.alibaba.fastjson.JSONObject;
import org.popkit.appkit.common.controller.BaseController;
import org.popkit.appkit.common.utils.ResponseUtils;
import org.popkit.appkit.log.AppKitLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * 为githb写的webhook调用链接
 * Author: Aborn Jiang
 * Email : aborn.jiang AT foxmail.com
 * Date  : 10-11-2015
 * Time  : 1:49 PM
 */
@Controller
@RequestMapping(value = "/webhook")
public class WebHookController extends BaseController {

    // push事件的webhook
    @RequestMapping(value = "/popkit.push")
    public void popkitPush(HttpServletRequest request,
                           HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("uri", request.getRequestURI());
        jsonObject.put("url", request.getRequestURL());

        String event = request.getHeader("X-Github-Event");   // 事件
        String ua = request.getHeader("User-Agent");
        String signature = request.getHeader("X-Hub-Signature"); // 签名

        jsonObject.put("event", event == null ? "null" : event);
        jsonObject.put("ua", ua == null ? "null" : ua);
        jsonObject.put("signature", signature == null ? "null" : signature);
        boolean isLegal = isLegalUser(event, ua, signature);
        jsonObject.put("isLegal", isLegal);

        //if (isLegal) {
            doPopkitPushAction();
        //}

        AppKitLog.info("popkit.push call. " + jsonObject.toJSONString());
        ResponseUtils.renderJson(response, jsonObject.toJSONString());
    }

    // 执行命令
    private void doPopkitPushAction() {
        try {
            String homePath = System.getProperty("user.home");
            String shellFile = homePath + "/github/popkit/shell/popkit.sh";
            File file = new File(shellFile);
            if (!file.exists()) {
                AppKitLog.info("shell file:" + shellFile + "doesnot exist!");
                return;
            }

            File fileLog = new File(homePath + "/log.txt");
            if (!fileLog.exists()) {
            }

            String shellString = "/bin/bash " + shellFile + " &>" + homePath + "/log.txt";
            Process process = Runtime.getRuntime().exec(shellString);
            int exitValue = process.waitFor();
            if (0 != exitValue) {
                AppKitLog.info("call shell " + shellString + " failed. error code is :" + exitValue);
            } else {
                AppKitLog.info("call shell " + shellString + " success. success code is :" + exitValue);
            }
        } catch (Throwable e) {
            AppKitLog.info("call shell failed exception. " + e.getMessage());
        }
    }

    private boolean isLegalUser(String event, String ua, String signature) {
        if (event == null || ua == null || signature == null) {
            return false;
        }

        return "push".equals(event) &&
                ua.startsWith("GitHub-Hookshot") &&
                getLocalSignature().equals(signature);
    }

    private static String getLocalSignature() {
        String userHome = System.getProperty("user.home");
        String fileName = userHome + "/github/eden/github/popkit.xml";
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(fileName);
            NodeList nodeList = document.getElementsByTagName("git.webhook.signature");
            return nodeList.item(0).getTextContent();
        } // 文件没找到
        catch (FileNotFoundException e) {
            return "";
        }
        catch (Throwable throwable) {
            return "";
        }
    }

    public static void main(String[] argc) {
        String signature = getLocalSignature();
        System.out.print("signature:" + signature);
    }
}