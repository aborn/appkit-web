package org.popkit.appkit.demo.controller;

import org.popkit.appkit.common.annotation.AuthorityPolicy;
import org.popkit.appkit.common.controller.BaseController;
import org.popkit.appkit.common.entity.ResponseJSON;
import org.popkit.appkit.common.utils.ResponseUtils;
import org.popkit.appkit.demo.entity.TabInfoDo;
import org.popkit.appkit.demo.entity.UserInfoDo;
import org.popkit.appkit.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Uri start with /demo/*
 *
 * @author guobao.jiang
 * @date 3/12/15
 * @time 11:27 PM
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController extends BaseController {

    public DemoController() {}

    @Autowired
    private DemoService demoService;

    /**
     * Dynamic uri example
     * @param modelMap variable to view layer
     * @param name dynamic variable
     * @return ftl page
     */
    @RequestMapping(value = "/demo.html/name/{name}", method = RequestMethod.GET)
    public String dynamicUriExample(@ModelAttribute("model")ModelMap modelMap,
                                    @PathVariable String name) {
        String info = "Hello world!";
        info +=  " The dynamic value of name is " + name;
        buildDemoPageContent(modelMap, info, "demo web page");
        return "demo/demo";
    }

    /**
     * Get request with parameter
     * @param modelMap variable to view layer
     * @param nameInput get request parameter
     * @return
     */
    @RequestMapping(value = "/get.html", method = RequestMethod.GET)
    public String getWithParameters(@ModelAttribute("model")ModelMap modelMap,
                                    @RequestParam(value = "name", required = false)String nameInput) {
        buildDemoPageContent(modelMap, "Http get request with parameter, name=" + nameInput,
                "demo get request");
        return "demo/demo";
    }

    /**
     * DataBase operating example
     * @param doList list result to view layer
     * @param id query user id
     * @return
     */
    @RequestMapping(value = "/db.html", method = RequestMethod.GET)
    public String dbCallExample(@ModelAttribute("data") ArrayList<UserInfoDo> doList,
                                @ModelAttribute("tabinfo") TabInfoDo tabInfoDo,
                                @RequestParam(value = "id", required = false)Integer id) {
        List<UserInfoDo> allValues = null;
        if (null == id) {
            allValues = demoService.queryAllUsersInfo();
            tabInfoDo.setSize(allValues.size());
            doList.addAll(allValues);
        } else {
            UserInfoDo userInfoDo = demoService.queryUsersInfo(id);
            doList.add(userInfoDo);
            tabInfoDo.setSize(1);
        }

        //demoService.insert("aborn", "Shanghai");
        return "demo/db";
    }

    @AuthorityPolicy(scene = "db")
    @RequestMapping(value = "/addUser.html", method = RequestMethod.POST)
    public String dbSubmitExample(@ModelAttribute(value = "user") UserInfoDo userInfoDo) {
        if (userInfoDo != null) {
            //demoService.insert(userInfoDo.getName(), userInfoDo.getAddress());
        }

        return "redirect:/demo/db.html";
    }

    @RequestMapping(value = "/editor.html")
    public String editor() {
        return "demo/editor";
    }

    @RequestMapping(value = "/editorsumbitcontent.html")
    public void editorSubmit(HttpServletResponse response,
                             String content) {
        ResponseJSON json = new ResponseJSON();
        json.setInfo("success, content:" + content);
        json.setStatus(ResponseJSON.STATUS_SUCCESS);
        ResponseUtils.renderJson(response, json.toJSONString());
    }

    @AuthorityPolicy(scene = "null")
    @RequestMapping(value = "/getJSON.html", method = RequestMethod.GET)
    public void getJSONData(HttpServletResponse httpResponse) {
        ResponseJSON responseJSON = new ResponseJSON();

        responseJSON.setStatus(ResponseJSON.STATUS_SUCCESS);
        responseJSON.setInfo("get success!");
        ResponseUtils.renderJson(httpResponse, responseJSON.toJSONString());
    }

    private void buildDemoPageContent(ModelMap modelMap, String info, String pageTitle) {
        modelMap.addAttribute("info", info);
        modelMap.addAttribute("pageTitle", pageTitle);
        modelMap.addAttribute("class", this.getClass().toString());
    }
}
