package org.popkit.appkit.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.popkit.appkit.common.annotation.AuthorityPolicy;
import org.popkit.appkit.common.controller.BaseController;
import org.popkit.appkit.common.entity.ResponseJSON;
import org.popkit.appkit.common.utils.ResponseUtils;
import org.popkit.appkit.demo.entity.*;
import org.popkit.appkit.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Uri start with /demo/*
 * Author: Aborn Jiang
 * Email : aborn.jiang AT foxmail.com
 * Date 3/12/15
 * Time 11:27 PM
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController extends BaseController {

    private static final Map<String, List<LayoutItem>> demoStatic = new HashMap<String, List<LayoutItem>>();

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
        String info = "Hello world!你好！";
        info +=  " The dynamic value of name is " + name;
        buildDemoPageContent(modelMap, info, "demo web page");
        return "demo/demo";
    }

    /**
     * 只接受Get请求
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

    @RequestMapping("/ele/ele.html")
    public String demoEle(HttpServletRequest request, HttpServletResponse response) {
        List<Option> selectLayouts = new ArrayList<Option>();
        for (String layout : demoStatic.keySet()) {
            selectLayouts.add(new Option(layout, layout));
        }

        request.setAttribute("selectLayouts", selectLayouts);
        return "demo/ele/ele";
    }

    @RequestMapping("/ele/elesubmit.html")
    public void demoSubmit(String layoutName, String layoutValue, String order,
                           HttpServletRequest request, HttpServletResponse response) {
        ResponseJSON responseJSON = new ResponseJSON();
        String[] orderArr = order.split(" ");
        Object object = JSONArray.parse(layoutValue);
        List<LayoutItem> result = new ArrayList<LayoutItem>();
        for (int i=0; i<((JSONArray) object).size(); i++) {
            JSONObject jsonObject = (JSONObject)(((JSONArray) object).get(i));
            LayoutItem item = new LayoutItem(jsonObject);
            item.setOrder(Integer.parseInt(orderArr[i]));
            result.add(item);
        }

        if (StringUtils.isNotBlank(layoutName) && (!demoStatic.containsKey(layoutName))) {
            demoStatic.put(layoutName, result);
        }
        responseJSON.setStatus("success");
        responseJSON.setInfo("成功");
        ResponseUtils.renderJson(response, responseJSON.toJSONString());
    }

    @RequestMapping("/ele/getlayout.gson")
    public void getLayoutGSON(String layoutName, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();


        List<LayoutItem> result = demoStatic.get(layoutName);
        if (CollectionUtils.isNotEmpty(result)) {
            jsonObject.put("status", "success");
            jsonObject.put("info", "has data");
            JSONArray jsonArray = new JSONArray();
            for (LayoutItem item : result) {
                jsonArray.add(JSONObject.toJSON(item));
            }
            jsonObject.put("data", jsonArray);
        } else {
            jsonObject.put("status", "error");
            jsonObject.put("info", "has not data");
        }



        ResponseUtils.renderJson(response, jsonObject.toJSONString());
    }

    @RequestMapping("democity.html")
    public String demoCity(HttpServletRequest request) {
        return "demo/democity";
    }

    @RequestMapping("demoMock.json")
    public void demoMock(HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        jsonObject.put("info", simpleDateFormat.format(new Date()));
        ResponseUtils.renderJson(response, jsonObject.toJSONString());
    }

    // test url: http://localhost:8080/demo/demoArg.json?id=1&name=aborn
    @RequestMapping("demoArg.json")
    public void demoArg(ArgReq req, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "success");
        jsonObject.put("info", req.toString());
        ResponseUtils.renderJson(response, jsonObject.toJSONString());
    }
}
