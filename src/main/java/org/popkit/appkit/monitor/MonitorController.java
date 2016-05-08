package org.popkit.appkit.monitor;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.popkit.appkit.common.config.AppkitConfigActor;
import org.popkit.appkit.common.controller.BaseController;
import org.popkit.appkit.common.utils.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Aborn Jiang
 * Mail aborn.jiang@gmail.com
 * 2016-05-07:21:34
 */
@Controller
@RequestMapping(value = "monitor")
public class MonitorController extends BaseController {
    private static final DateTimeFormatter DEFAULT_FORMAT = DateTimeFormat.forPattern("MM-dd HH:mm");
    private static final DateTimeFormatter SHORT_FORMAT = DateTimeFormat.forPattern("MM-dd HH:");
    private static final DateTimeFormatter LOG_DATE_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"); //2015-09-11 01:17:51
    private static final String DEBUG_TIME = "2015-09-11 01:17:51";
    private static final String DEFAULT_SS_KEY = "sslog";

    @RequestMapping(value = "ss.html")
    public String ss(HttpServletRequest request) {
        List<String> timeList = buildSelection();
        request.setAttribute("timeList", timeList);
        request.setAttribute("currentTime", timeList.get(0));
        return "monitor/ss-monitor";
    }

    @RequestMapping(value = "ajaxss.json")
    public void ajaxss(@RequestParam(value = "timeValue") String timeValue,
                       HttpServletResponse response) {
        if (StringUtils.isBlank(timeValue)) {
            timeValue = DEBUG_TIME; //DateTime.now().toString(LOG_DATE_FORMAT);
        } else {
            timeValue = timeValue + " 01:17:51";
        }
        List<String> labels = buildLabels(timeValue);
        List<Integer> data = new ArrayList<Integer>();
        for (String item : labels) {
            data.add(0);
        }

        EachLine eachLine = new EachLine(labels, data);
        List<EachLogItem> logItems = readLogFileContent(getDateTime(timeValue));

        doStatistics(logItems, labels, data, 10);
        eachLine.setLabel(getDateTime(timeValue).toString(DateTimeFormat.forPattern("yyyy-MM-dd")));
        ResponseUtils.renderJson(response, eachLine.toString());
    }

    private List<String> buildSelection() {
        List<String> result = new ArrayList<String>();
        DateTime now = DateTime.now();

        for (int i=0; i<7; i++) {
            result.add(now.plusDays(0-i).toString(DateTimeFormat.forPattern("yyyy-MM-dd")));
        }

        return result;
    }

    private void doStatistics(List<EachLogItem> logItems, List<String> labels, List<Integer> date, int step) {
        Map<String, Integer> indexMap = buildMap(labels);
        if (CollectionUtils.isNotEmpty(logItems)) {
            for (EachLogItem logItem : logItems) {
                DateTime dateTime = getDateTime(logItem.getTime());
                String shortString = dateTime.toString(SHORT_FORMAT);
                int minuteOfHour = dateTime.getMinuteOfHour();
                String time = shortString + (minuteOfHour / step) + "0";
                if (indexMap.containsKey(time)) {
                    Integer va = date.get(indexMap.get(time)) + 1;
                    date.set(indexMap.get(time), va);
                }
            }
        }
    }

    private Map<String, Integer> buildMap(List<String> labels) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int index = 0;
        for (String item : labels) {
            map.put(item, index ++);
        }
        return map;
    }

    public List<EachLogItem> readLogFileContent(DateTime dateTime) {
        List<EachLogItem> result = new ArrayList<EachLogItem>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(AppkitConfigActor.get(DEFAULT_SS_KEY)));
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                EachLogItem item = new EachLogItem(sCurrentLine.substring(0,19), sCurrentLine);
                DateTime thisLineDate = getDateTime(item.getTime());
                if (thisLineDate.getDayOfYear() == dateTime.getDayOfYear()) {
                    result.add(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    private DateTime getDateTime(String dateString) {
        return DateTime.parse(dateString, LOG_DATE_FORMAT);
    }

    List<String> buildLabels(String monitorDayString) {
        List<String> labels = new ArrayList<String>();
        DateTime monitorDay = DateTime.parse(monitorDayString, LOG_DATE_FORMAT);
        List<DateTime> stepList = buildStepDateTimeList(10, monitorDay);
        if (CollectionUtils.isNotEmpty(stepList)) {
            for (DateTime time : stepList) {
                labels.add(time.toString(DEFAULT_FORMAT));
            }
        }
        return labels;
    }

    List<DateTime> buildStepDateTimeList(int step, DateTime monitorDay) {
        List<DateTime> result = new ArrayList<DateTime>();
        DateTime todayStart = monitorDay.withTimeAtStartOfDay();
        DateTime tomorrowStart = monitorDay.plusDays( 1 ).withTimeAtStartOfDay();

        DateTime tmp = todayStart.plus(Period.minutes(step));
        while (tomorrowStart.isAfter(tmp)) {
            result.add(tmp);
            tmp = tmp.plus(Period.minutes(step));
        }

        return result;
    }
}
