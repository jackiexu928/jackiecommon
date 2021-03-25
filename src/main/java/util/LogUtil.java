package util;

import org.slf4j.Logger;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2020-04-29
 */
public class LogUtil {
    public static void debug(Logger logger, String functionName, Object param, Object obj) {
        logger.debug("方法名：[" + functionName + "]\n" +
                "参数：[" + param + "]\n", obj);
    }

    public static void debug(Logger logger, String functionName, Object param, String message) {
        logger.debug("方法名：[" + functionName + "]\n" +
                "参数：[" + param + "]\n", message);
    }

    public static void debug(Logger logger, String functionName, Object param, Throwable e) {
        logger.debug("方法名：[" + functionName + "]\n" +
                "参数：[" + param + "]\n", e);
    }

    public static void info(Logger logger, String functionName, Object param, Object obj) {
        logger.info("方法名：[" + functionName + "]\n" +
                "参数：[" + param + "]\n", obj);
    }

    public static void info(Logger logger, String functionName, Object param, String message) {
        logger.info("方法名：[" + functionName + "]\n" +
                "参数：[" + param + "]\n"+"阶段信息：["+ message+"]");
    }

    public static void info(Logger logger, String functionName, Object param, Throwable e) {
        logger.info("方法名：[" + functionName + "]\n" +
                "参数：[" + param + "]\n", e);
    }


    public static void error(Logger logger, String functionName, Object param, Object obj) {
        logger.error("方法名：[" + functionName + "]\n" +
                "参数：[" + param + "]\n"+"错误信息：["+obj+"]");
    }

    public static void error(Logger logger, String functionName, Object param, String message) {
        logger.error("方法名：[" + functionName + "]\n" +
                "参数：[" + param + "]\n"+"错误信息：["+message+"]");
    }

    public static void error(Logger logger, String functionName, Object param, Throwable e) {
        logger.error("方法名：[" + functionName + "]\n" +
                "参数：[" + param + "]\n",e);
    }
}
