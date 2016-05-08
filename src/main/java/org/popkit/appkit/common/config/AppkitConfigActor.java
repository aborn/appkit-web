package org.popkit.appkit.common.config;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aborn Jiang
 * Mail aborn.jiang@gmail.com
 * 2016-05-08:10:14
 */
public class AppkitConfigActor {
    private static final String CONFIG_FILE_UNIX = "/data/webapps/";
    private static final String CONFIG_FILE_WINDOWS = "D:/data/webapps/";
    private static final String APPKIT_CONFIG_FILE_NAME = "appkit.conf";

    public static String getWebappsRoot() {
        return SystemUtils.IS_OS_WINDOWS ?
                CONFIG_FILE_WINDOWS :
                CONFIG_FILE_UNIX;
    }

    public static Map<String, String> getConfigMap() {
        Map<String,String> result = new HashMap<String, String>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(getWebappsRoot() + APPKIT_CONFIG_FILE_NAME));
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                if (StringUtils.isNotBlank(sCurrentLine) && (!sCurrentLine.trim().startsWith("#"))) {
                    String[] keyValuePair = sCurrentLine.split("=");
                    if (keyValuePair.length > 1) {
                        result.put(keyValuePair[0].trim(), keyValuePair[1].trim());
                    }
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
}
