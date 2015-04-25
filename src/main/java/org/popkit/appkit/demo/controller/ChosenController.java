package org.popkit.appkit.demo.controller;

import org.popkit.appkit.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: aborn.jiang
 * Email : aborn.jiang AT foxmail.com
 * Date  : 4/25/15
 * Time  : 9:09 PM
 */
@Controller
@RequestMapping(value = "/demo")
public class ChosenController extends BaseController {

    @RequestMapping(value = "chosen.html")
    public String useChosen(@ModelAttribute("cityChosen")String cities) {
        return "demo/chosen";
    }
}
