package util;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2020-10-04
 */
public class ConfigSetPropertyHolder {
    public static void init(){
        System.setProperty("datesourceUrl", "jdbc:mysql://localhost:3306/shares?serverTimezone=Asia/Shanghai");
    }
}
