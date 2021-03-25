package util;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 */
public class MapUtil {
    public static <T> Map<String, List<T>> update(Map<String, List<T>> map, String key, T object){
        if (map.containsKey(key)){
            map.get(key).add(object);
        } else {
            map.put(key, ListUtil.getList(object));
        }
        return map;
    }
}
