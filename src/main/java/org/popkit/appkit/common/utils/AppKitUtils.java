package org.popkit.appkit.common.utils;

import org.apache.commons.lang.StringUtils;

/**
 * @author guobao.jiang
 * @date 3/13/15
 * @time 12:23 AM
 */
public class AppKitUtils {

    public static String getContentType(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            return "";
        }

        if (fileName.endsWith(".gif")) {
            return "image/gif";
        } else if (fileName.endsWith(".jpeg") || fileName.endsWith(".jpg")) {
            return "image/jpg";
        } else if (fileName.endsWith(".png")) {
            return "image/png";
        } else if (fileName.endsWith(".json")) {
            return "application/json";
        } else if (fileName.endsWith(".txt") || fileName.endsWith(".text")) {
            return "text/plain";
        }

        return "";
    }
}
