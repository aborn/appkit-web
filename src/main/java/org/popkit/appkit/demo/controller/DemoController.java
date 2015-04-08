package org.popkit.appkit.demo.controller;

import org.popkit.appkit.common.controller.BaseController;
import org.popkit.appkit.demo.entity.BasicDo;
import org.popkit.appkit.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
     * @param modelMap
     * @param name
     * @return
     */
    @RequestMapping(value = "/demo.html/name/{name}", method = RequestMethod.GET)
    public String dynamicUriExample(@ModelAttribute("model")ModelMap modelMap,
                                    @PathVariable String name) {
        String info = "Hello world!";
        info +=  " The dynamic value of name is" + name;
        buildDemoPageContent(modelMap, info, "demo web page");
        return "demo/demo";
    }

    /**
     * Get request with parameter
     * @param modelMap
     * @param nameInput
     * @return
     */
    @RequestMapping(value = "/get.html", method = RequestMethod.GET)
    public String getWithParameters(@ModelAttribute("model")ModelMap modelMap,
                                    @RequestParam(value = "name", required = false)String nameInput) {
        buildDemoPageContent(modelMap, "带参数的Get请求, name=" + nameInput, "demo");
        return "demo/demo";
    }

    @RequestMapping(value = "/db.html", method = RequestMethod.GET)
    public String dbCallExample(@ModelAttribute("data") ArrayList<BasicDo> doList,
                                @RequestParam(value = "id", required = false)Integer id) {
        List<BasicDo> allValues = demoService.queryAllUsersInfo();
        //demoService.insert("aborn", "Shanghai");
        return "demo/db";
    }

    private void buildDemoPageContent(ModelMap modelMap, String info, String pageTitle) {
        modelMap.addAttribute("info", info);
        modelMap.addAttribute("pageTitle", pageTitle);
        modelMap.addAttribute("class", this.getClass().toString());
    }
}
