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
import java.util.Iterator;
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
        List<CityInfo> cityInfos = getCityList();
        Iterator<CityInfo> infoIterator = cityInfos.iterator();
        while (infoIterator.hasNext()) {
            if (infoIterator.next().getCityName().contains(q)) {
                continue;
            } else {
                infoIterator.remove();
            }
        }

        SearchResult<CityInfo> searchResult = new SearchResult<CityInfo>();
        searchResult.setRecords(cityInfos);

        ResponseUtils.renderJson(response, searchResult.toString());
    }

    @RequestMapping(value = "citysubmit.html")
    public String citySubmit(
            HttpServletRequest request,
            String cityName, String cityId) {
        request.setAttribute("cityName", cityName);
        request.setAttribute("info", "(城市名:" + cityName + ", 城市id:" + cityId + ")");
        return "semantic/index";
    }

    private List<CityInfo> getCityList() {
        List<CityInfo> examples = new ArrayList<CityInfo>();
        examples.add(new CityInfo("北京", 1));
        examples.add(new CityInfo("上海", 2));
        examples.add(new CityInfo("上海浦东", 77));
        examples.add(new CityInfo("广州", 3));
        examples.add(new CityInfo("深圳", 4));
        examples.add(new CityInfo("上饶", 87));
        return examples;
    }
}
