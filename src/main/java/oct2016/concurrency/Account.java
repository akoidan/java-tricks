package oct2016.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by andrew on 11/26/16.
 */
public class Account {

    static AtomicInteger globalId = new AtomicInteger(0);
    private int balance;
    private int id;

    public Account(int balance) {
        this.balance = balance;
        this.id = globalId.get();
        globalId.incrementAndGet();
    }

    public int getId() {
        return this.id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdraw(Integer value) {
        this.balance -= value;
    }

    @Override
    public String toString() {
        return "balance=\"" + balance + '"';
    }

    public void deposit(Integer value) {
        this.balance += value;
    }
}
