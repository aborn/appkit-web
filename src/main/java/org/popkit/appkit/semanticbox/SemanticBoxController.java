package org.popkit.appkit.semanticbox;

import org.popkit.appkit.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Aborn Jiang
 * Email : aborn.jiang AT foxmail.com
 * Date  : 11-01-2015
 * Time  : 10:24 PM
 */
@Controller
@RequestMapping(value = "semanticbox")
public class SemanticBoxController extends BaseController {

    @RequestMapping(value = "index.html")
    public String index() {
        return "semanticbox/semanticbox";
    }
}
