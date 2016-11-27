package oct2016.concurrency;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by andrew on 11/26/16.
 */
public class DeadLock implements Runnable {

    static Account a = new Account(10);
    static Account b = new Account(20);

    static Lock l = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new DeadLock());
        thread.start();
        transferLock(a, b, 5);

    }



    static void transfer(Account a, Account b, int amount) throws InterruptedException {
        Account lockFirst = a.getId() < b.getId() ? a : b;
        Account lockSecond = a.getId() > b.getId() ? a : b;
        synchronized (lockFirst) {
            Thread.sleep(1000);
            System.out.printf("%5s: %d, Locked on %s \n", new Date().getTime(), amount, lockFirst.hashCode());
            synchronized (lockSecond) {
                System.out.printf("%5s: %d Locked on %s \n", new Date().getTime(), amount, lockSecond.hashCode());
                if (a.getBalance() < amount) {
                    throw new RuntimeException("Too l ow");
                }
                a.withdraw(amount);
                b.deposit(amount);

                System.out.printf("A %s, B %s \n", a, b);
            }
        }
    }


    static void transferLock(Account a, Account b, int amount) throws InterruptedException {
        Thread.sleep(1000);
        System.out.printf("%5s: %d, before lock \n", new Date().getTime(), amount);
        l.lock();
        System.out.printf("%5s: %d, After lock \n", new Date().getTime(), amount);
        Thread.sleep(1000);
        try {
            if (a.getBalance() < amount) {
                throw new RuntimeException("Too l ow");
            }
            a.withdraw(amount);
            b.deposit(amount);
        } finally {
            System.out.printf("A %s, B %s \n", a, b);
            l.unlock();
        }
    }

    @Override
    public void run() {
        try {
            transferLock(b, a, 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
