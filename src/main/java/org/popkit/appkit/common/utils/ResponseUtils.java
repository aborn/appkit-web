package org.popkit.appkit.common.utils;

import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Author: aborn.jiang
 * Email : aborn.jiang AT foxmail.com
 * Date  : 4/15/15
 * Time  : 12:03 AM
 */
public class ResponseUtils {
    public static void renderText(HttpServletResponse response, String text) {
        render(response, "text/plain", text);
    }

    public static void renderXml(HttpServletResponse response, String text) {
        render(response, "text/xml", text);
    }

    public static void renderHtml(HttpServletResponse response, String text) {
        render(response, "text/html", text);
    }

    public static void renderJavaScript(HttpServletResponse response, String text) {
        render(response, "text/javascript", text);
    }

    public static void renderJson(HttpServletResponse response, String text) {
        render(response, "application/json", text);
    }

    public static void render(HttpServletResponse response, String contentType, String text) {
        response.setContentType(contentType + "; charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        Writer writer = null;
        try {
            writer = response.getWriter();
            response.getWriter().write(text);
        } catch (IOException e) {
        } finally {
            IOUtils.closeQuietly(writer);
        }
    }
}
