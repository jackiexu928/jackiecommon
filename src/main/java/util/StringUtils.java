package util;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2020-10-05
 */
public class StringUtils {
    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }
}
