package oct2016.newconc;

import java.util.concurrent.Semaphore;

/**
 * Created by andrew on 11/26/16.
 */
public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(10);
        semaphore.acquire(1);
        System.out.println(1);
        semaphore.acquire(6);
        System.out.println(6);
        semaphore.acquire(7);
        System.out.println(7);
        semaphore.release();

    }


}
