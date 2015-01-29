package concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.InsufficientResourcesException;

public class Operations {

	int failcount = 0;

	public static void main(String[] arg) throws InterruptedException {

		final AtomicInteger failcount = new AtomicInteger(0);
		final Account a = new Account(1000);
		final Account b = new Account(2000);

		ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				System.out.println("SCHEDULE: " + failcount.toString());
			}
		}, 0, 1000, TimeUnit.MILLISECONDS);

		ExecutorService service = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 30; i++) {
			service.submit(new Transfer(a, b, new Random().nextInt(40), i, failcount));
		}
		System.out.println("main Thread slept");
		Thread.sleep(200);
		service.shutdown();
		try {
			System.out.println("started wait");
			service.awaitTermination(3, TimeUnit.SECONDS);
			System.out.println("wait is complete");
			service.shutdownNow();
			System.out.println("Service has been shutted down");
			scheduledExecutorService.shutdown();
			System.out.println("Schedule has been shutted down");

		} catch (InterruptedException ex) {
			Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
		}

//	new Thread(new Transfer(a, b, 100));
//
//	new Thread(new Runnable() {
//
//		@Override
//		public void run() {
//			try {
//				threadSafeTransfer(a,b,500);
//			} catch (InsufficientResourcesException ex) {
//				System.err.println(ex);
//			}
//		}}).start();
//		try {
//			threadSafeTransfer(b,a,500);
//		} catch (InsufficientResourcesException ex) {
//			System.err.println(ex);
//		}
	}

	private static void threadSafeTransfer(Account accountFrom, Account accountTo, int amount) throws InsufficientResourcesException {
		String transfered = "fail";
		while (transfered.equals("fail")) {
			if (accountFrom.getBalance() < amount) {
				throw new InsufficientResourcesException("not enough balance");
			}
			try {/* if lock A is busy and Thread is interrapted while waitig 1 second 
				 a.getLock().tryLock(1, TimeUnit.SECONDS must be processed
				 */

				if (accountFrom.getLock().tryLock(/*1, TimeUnit.SECONDS*/)) {
					try { // If inner code of A.lock fail
						System.out.println("Logged into a: " + accountFrom + " " + System.currentTimeMillis());
						if (accountTo.getLock().tryLock(/*1, TimeUnit.SECONDS*/)) {
							try { //Execute transfer exception
								System.out.println("Logged into b: " + accountTo + " " + System.currentTimeMillis());
								accountFrom.withdraw(amount);
								accountTo.deposit(amount);
								transfered = "succeded" + System.currentTimeMillis();
							} catch (Exception e) {
								System.err.println("Exception on execute transfer operation = " + e + " " + System.currentTimeMillis());
							} finally {
								accountTo.getLock().unlock();
							}
						} else {
							System.err.println(accountTo + " (b) is locked " + System.currentTimeMillis());
						}
					} catch (Exception e) {
						System.err.println("Something fail inside of locked A" + System.currentTimeMillis());
					} finally {
						accountFrom.getLock().unlock();
					}
				} else {
					System.err.println(accountFrom + " (a) is locked" + System.currentTimeMillis());
				}
			} catch (Exception ex) {
				System.err.println("Lock waiting has been interrupted" + ex);
			}
			StringBuilder builder = new StringBuilder();
			builder.append("transfer ").append(accountFrom).append(" to ").append(accountTo).append(" ").append(transfered);
			if (transfered.equals("fail")) {
				accountFrom.incFailedTransferCount();
				accountTo.incFailedTransferCount();
				throw new InsufficientResourcesException(builder.toString());
			} else {
				System.out.println(builder);
			}
		}
	}

	private static void transfer(Account a, Account b, int i) throws InsufficientResourcesException {
		if (a.getBalance() < i) {
			throw new InsufficientResourcesException("not enough balance");
		}
		synchronized (a) {

			synchronized (b) {
				System.out.println("Logged into b: " + b);
				a.withdraw(i);
				b.deposit(i);
			}
		}
		System.out.println("transer "
			+ " succeded");
	}
}
