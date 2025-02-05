package utilities;

import org.apache.logging.log4j.LogManager;

public class log {


    public static String path = "Test_output/logs";

    public static void trace(String msg) {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString())
                .trace(msg);
    }

    public static void debug(String msg) {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString())
                .debug(msg);
    }

    public static void info(String msg) {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString())
                .info(msg);
    }

    public static void warn(String msg) {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString())
                .warn(msg);
    }

    public static void error(String msg) {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString())
                .error(msg);
    }

    public static void fatal(String msg) {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString())
                .fatal(msg);
    }

}
