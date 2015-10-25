package org.popkit.appkit.semantic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: guobao.jiang
 * Email : guobao.jiang@dianping.com
 * Date  : 10-25-2015
 * Time  : 10:09 AM
 */
@Controller
@RequestMapping(value = "/semantic")
public class SemanticController {

    @RequestMapping(value = "index.html")
    public String index() {

        return "semantic/index";
    }

}
