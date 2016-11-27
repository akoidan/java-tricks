package oct2016.collections;

import java.util.*;

/**
 * Created by andrew on 11/26/16.
 */
public class SetTest {
    public static void main(String[] args) {
        testTreeComp();
        Set lol = new LinkedHashSet<>();
    }



    private static void testTreeComp() {
        Set<Integer> set = new TreeSet<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        set.add(1);
        set.add(2);
        set.add(1);
        System.out.println(set);
    }
}
