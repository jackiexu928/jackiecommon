package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 */
public class ListUtil {
    public static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean isNotEmpty(List list) {
        return !isEmpty(list);
    }

    public static <T>List<T> getList(T object){
        List<T> list = new ArrayList<T>();
        list.add(object);
        return list;
    }

    public static <T>List<T> getFixedSizeList(T object, int size){
        List<T> list = new ArrayList<T>(size);
        list.add(object);
        return list;
    }
}
