package last.Concurency;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Operations {

	private static void transfer(Account accountA, Account accountB, int amount) {

		if (accountA.lock.tryLock()) {
			System.out.println("locked" + accountA);
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
			}
			System.out.println(" waiting for " + accountB);
			if (accountB.lock.tryLock()) {
				System.out.println(accountB + " b locked");
				accountA.withdrow();
				accountB.deposit();
				System.out.println(String.format("%s to %s done", accountA, accountB));
				System.out.println(" Unlock " + accountB);
			} else {
				accountA.incFail();
				accountB.incFail();
			}
			System.out.println(" Unlock " + accountA);
			accountA.lock.unlock();
		} else {
			accountA.incFail();
			accountB.incFail();
		}

	}

	public static void main(String[] args) {

		final Account accountA = new Account(1000);
		final Account accountB = new Account(1000);

		new Thread(new Runnable() {

			@Override
			public void run() {

				transfer(accountA, accountB, 500);

			}

		}).start();
		transfer(accountB, accountA, 300);

	}
}
