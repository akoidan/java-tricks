package oct2016.concColl;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by andrew on 11/26/16.
 */
public class CopyOnWriteArrListTest implements Callable<Long> {

    int runFrom = 0;
    Collection<Integer> col;
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public CopyOnWriteArrListTest(int runFrom, Collection<Integer> col) {
        this.runFrom = runFrom;
        this.col = col;
    }

    public static void main(String[] args) {
        //new CopyOnWriteArrayList<>();
        Collection<Integer> c = Collections.synchronizedCollection(new ArrayList<>(100));
        fillData(c);
        new CopyOnWriteArrListTest(50, c);

    }

    public static void fillData(Collection<Integer> c) {
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            c.add(r.nextInt());
        }
    }

    @Override
    public Long call() throws Exception {
        countDownLatch.await();
        long before = System.nanoTime();
        for (int i = runFrom; i < runFrom + 49; i++) {
            System.out.println();//not finished
        }

        return System.nanoTime() - before;
    }
}
