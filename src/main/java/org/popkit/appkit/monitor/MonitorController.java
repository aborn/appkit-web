package org.popkit.appkit.monitor;

import org.apache.commons.collections.CollectionUtils;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.popkit.appkit.common.controller.BaseController;
import org.popkit.appkit.common.utils.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aborn Jiang
 * Mail aborn.jiang@gmail.com
 * 2016-05-07:21:34
 */
@Controller
@RequestMapping(value = "monitor")
public class MonitorController extends BaseController {
    private static final DateTimeFormatter defaultFormat = DateTimeFormat.forPattern("MM-dd HH:mm");

    @RequestMapping(value = "ss.html")
    public String ss() {
        return "monitor/ss-monitor";
    }

    @RequestMapping(value = "ajaxss.json")
    public void ajaxss(Integer type, HttpServletResponse response) {
        List<String> labels = buildLabels();
        List<Integer> data = new ArrayList<Integer>();
        for (String item : labels) {
            data.add(1);
        }

        EachLine eachLine = new EachLine(labels, data);

        ResponseUtils.renderJson(response, eachLine.toString());
    }

    List<String> buildLabels() {
        List<String> labels = new ArrayList<String>();
        List<DateTime> stepList = buildStepDateTimeList(10);
        if (CollectionUtils.isNotEmpty(stepList)) {
            for (DateTime time : stepList) {
                labels.add(time.toString(defaultFormat));
            }
        }
        return labels;
    }

    List<DateTime> buildStepDateTimeList(int step) {
        List<DateTime> result = new ArrayList<DateTime>();
        DateTime now = DateTime.now();
        DateTime todayStart = now.withTimeAtStartOfDay();
        DateTime tomorrowStart = now.plusDays( 1 ).withTimeAtStartOfDay();

        DateTime tmp = todayStart.plus(Period.minutes(step));
        while (tomorrowStart.isAfter(tmp)) {
            result.add(tmp);
            tmp = tmp.plus(Period.minutes(step));
        }

        return result;
    }
}
