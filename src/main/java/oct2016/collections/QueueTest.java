package oct2016.collections;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by andrew on 11/26/16.
 */
public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> lol = new PriorityQueue<>();
        lol.add(1);
        lol.add(3);
        lol.add(2);
        lol.add(5);
        while (!lol.isEmpty()) {
            System.out.println(lol.poll());
        }
    }
}
