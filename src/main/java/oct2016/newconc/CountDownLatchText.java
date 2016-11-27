package oct2016.newconc;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Execute all at once
 */
public class CountDownLatchText extends Thread{

    static CountDownLatch cdl =   new CountDownLatch(3);
    public static void main(String[] args) throws InterruptedException {
        new CountDownLatchText().start();
        Thread.sleep(100);
        new CountDownLatchText().start();
        Thread.sleep(100);
        new CountDownLatchText().start();
        // or countdown with 1, and countdown here
    }

    @Override
    public void run() {
        try {
            cdl.countDown();
            cdl.await();
            System.out.println(new Date().getTime());
        } catch (InterruptedException e) {

        }
    }
}
