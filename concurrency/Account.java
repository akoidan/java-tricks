package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	int balance;
	private AtomicInteger failCounter;



	public void incFailedTransferCount() {
		this.failCounter.incrementAndGet(); 
	}
	

	
	
	Lock lock;

	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}
	
	public int getBalance() {
		return balance;
	}

	public Account(int balance) {
		failCounter= new AtomicInteger(0);
		lock = new ReentrantLock();
		this.balance = balance;
	}
	public void withdraw(int amount) {
		 balance--;
	}
	public void deposit(int amount ) {
		balance++;
	}
}
