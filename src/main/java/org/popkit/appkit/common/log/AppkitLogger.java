package org.popkit.appkit.common.log;


import org.apache.log4j.Logger;

/**
 * Created by Aborn Jiang
 * Mail aborn.jiang@gmail.com
 * 2016-04-28:22:01
 */
public class AppkitLogger {

    private static final Logger LOGGER = Logger.getLogger("appkit-monitor");

    private AppkitLogger() {}

    public static void info(String msg) {
        LOGGER.info(msg);
    }

    public static void info(String msg, Throwable t) {
        LOGGER.info(msg, t);
    }

    /**
     * 各类非核心流程 抛Exception 情况
     * @param msg
     * @param t
     */
    public static void warn(String msg, Throwable t) {
        LOGGER.warn(msg, t);
    }

    public static void warn(String msg) {
        LOGGER.warn(msg);
    }

    public static void debug(String msg) {
        LOGGER.debug(msg);
    }

    public static void debug(String msg, Throwable t) {
        LOGGER.debug(msg, t);
    }

    public static void error(String msg) {
        LOGGER.error(msg);
    }

    public static void error(String msg, Throwable t) {
        LOGGER.error(msg, t);
    }
}
