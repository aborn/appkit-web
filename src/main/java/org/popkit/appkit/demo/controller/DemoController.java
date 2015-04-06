package org.popkit.appkit.demo.controller;

import org.popkit.appkit.demo.entity.BasicDo;
import org.popkit.appkit.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author guobao.jiang
 * @date 3/12/15
 * @time 11:27 PM
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController {
    public DemoController() {}

    @Autowired
    private DemoService demoService;

    /**
     * Uri Template(with parameters)
     * @param modelMap
     * @param name
     * @return
     */
    @RequestMapping(value = "/demo.html/name/{name}", method = RequestMethod.GET)
    public String show(@ModelAttribute("model")ModelMap modelMap, @PathVariable String name) {
        String info = "Hello world!";
        try {
            List<BasicDo> allValues = demoService.queryAllUsersInfo();
            info += " size:" + allValues.size() + " name:" + name;
            //demoService.insert("aborn", "Shanghai");
        }catch (Exception e) {
            // do nothing
        }

        callBiz(modelMap, info, "示例页面");
        return "demo";
    }

    /**
     * Get request with parameter
     * @param modelMap
     * @param nameInput
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getWithParameters(@ModelAttribute("model")ModelMap modelMap,
                                    @RequestParam(value = "name", required = false)String nameInput) {
        callBiz(modelMap, "带参数的Get请求, name=" + nameInput, "demo");
        return "demo";
    }

    private void callBiz(ModelMap modelMap, String info, String pageTitle) {
        modelMap.addAttribute("info", info);
        modelMap.addAttribute("pageTitle", pageTitle);
        modelMap.addAttribute("class", this.getClass().toString());
        return;
    }
}
