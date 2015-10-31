package org.popkit.appkit.semantic.controller;

import org.popkit.appkit.common.controller.BaseController;
import org.popkit.appkit.common.utils.ResponseUtils;
import org.popkit.appkit.semantic.entity.CityInfo;
import org.popkit.appkit.semantic.entity.SearchResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Aborn Jiang
 * Email : aborn.jiang AT foxmail.com
 * Date  : 10-25-2015
 * Time  : 10:09 AM
 */
@Controller
@RequestMapping(value = "/semantic")
public class SemanticController extends BaseController {

    @RequestMapping(value = "index.html")
    public String index() {

        return "semantic/index";
    }

    @RequestMapping(value = "querycity.api")
    public void querycity(HttpServletRequest request,
                          String q,
                          HttpServletResponse response) {
        List<CityInfo> examples = new ArrayList<CityInfo>();
        examples.add(new CityInfo("上海", 2));
        examples.add(new CityInfo("北京", 1));
        examples.add(new CityInfo("beijing", 1));
        examples.add(new CityInfo("shanghai", 1));

        SearchResult<CityInfo> searchResult = new SearchResult<CityInfo>();
        searchResult.setRecords(examples);

        ResponseUtils.renderJson(response, searchResult.toString());
    }
}
