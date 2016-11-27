package oct2016.collections;

import java.util.*;

/**
 * Created by andrew on 11/26/16.
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new LinkedHashMap<>();
        Map<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>(123, 0.8f);
        map.put(5, "a");
        map.put(4, "b");
        map.put(3, "c");
        System.out.println(map);
    }
}
