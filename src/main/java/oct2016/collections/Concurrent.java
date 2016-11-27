package oct2016.collections;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by andrew on 11/26/16.
 */
public class Concurrent {

    volatile Concurrent a;

    public static void main(String[] args) {
        List<Integer> l = new Stack<>();
        l.add(1);
        l.add(2);
        l.add(4);
        l.add(3);
        Iterator<Integer> iterator = l.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            l.add(5);
        }


    }
}
