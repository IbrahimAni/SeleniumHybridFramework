package com.automation.utilities.logutils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;

public class Logs {
    public static Logger logger;
    static String log4jFilePath = System.getProperty("user.dir")+ File.separator+ "src/test/java/com/automation/utilities/logutils/log4j.properties";

    public Logs() {
        logger = Logger.getLogger(Logs.class);
        PropertyConfigurator.configure(log4jFilePath);
    }
    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logError(String message) {
        logger.error(message);
    }

    public static void logWarn(String message) {
        logger.warn(message);
    }

    public static void logFatal(String message) {
        logger.fatal(message);
    }

    public static void logDebug(String message) {
        logger.debug(message);
    }

    public static void logTrace(String message) {
        logger.trace(message);
    }
}
