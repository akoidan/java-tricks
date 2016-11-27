package oct2016.newconc;

import java.util.Date;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by andrew on 11/26/16.
 */
public class CyclicBarrierTest extends Thread {

    private int koko;

    static CyclicBarrier cb = new CyclicBarrier(4);

    public CyclicBarrierTest(int koko) {
        this.koko = koko;
    }

    public static void main(String[] args) throws InterruptedException {
        new CyclicBarrierTest(2).start();
        Thread.sleep(100);
        new CyclicBarrierTest(3).start();
        Thread.sleep(100);
        new CyclicBarrierTest(4).start();
        Thread.sleep(100);
        new CyclicBarrierTest(5).start();
        System.out.println("FINISHED");
        cb.reset();
    }

    @Override
    public void run() {

        System.out.println(new Date().getTime() + " BEFORE " + koko);
        try {
            cb.await();
            System.out.println(new Date().getTime() + " AFTER " + koko);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
