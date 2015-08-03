package org.popkit.appkit.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author guobao.jiang
 * @email guobao.jiang@dianping.com
 * @date 08-03-2015
 * @time 11:04 PM
 */
public class AppKitLog {
    private static final Logger logger = LoggerFactory.getLogger("appkit-monitor");

    public static void info(String msg) {
        logger.info(msg);
    }
}
