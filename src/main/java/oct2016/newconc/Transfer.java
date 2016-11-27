package oct2016.newconc;

import oct2016.concurrency.Account;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by andrew on 11/26/16.
 */
public class Transfer implements Callable<Boolean>{

    Account accountFrom;
    Account accountTo;
    int amount = 3;


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Account a = new Account(10);
        Account b = new Account(13);
        Transfer transfer = new Transfer(a, b, 2);
        Transfer transfer2 = new Transfer(a, b, 1);
        final ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Boolean> submit = service.submit(transfer);
        Future<Boolean> submit2 = service.submit(transfer2);
        service.shutdown();
        System.out.println(new Date().getTime());
        System.out.printf("%s, %s %s\n", new Date().getTime(), submit.get(), submit2.get());
        System.out.println(a.getBalance());

    }

    public Transfer(Account accountFrom, Account accountTo, int amount) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println("RUNS");
        Thread.sleep(1000);
        if (accountFrom.getBalance() < amount) {
            throw new RuntimeException("Too l ow");
        }
        accountFrom.withdraw(amount);
        accountTo.deposit(amount);
        System.out.println("DDDDDDDDDD" +accountFrom.getBalance());
        return true;
    }
}
