package oct2016.newconc;

import java.util.Random;

/**
 * Created by andrew on 11/26/16.
 */
public class ThreadLocalT extends Thread {

    static Random r = new Random();

    ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return r.nextInt(99);
        }
    };

    public static void main(String[] args) {
        new ThreadLocalT().start();
        new ThreadLocalT().start();
        new ThreadLocalT().start();
        new ThreadLocalT().start();
        new ThreadLocalT().start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(r.nextInt(10));
                System.out.println(threadLocal.get() + " : " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
