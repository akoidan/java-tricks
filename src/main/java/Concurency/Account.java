package Concurency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

	
	int failcounter;
	
	public void incFail() {
		failcounter++;
	}

	public int getFailcounter() {
		return failcounter;
	}
	
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	Lock lock;
	
	private int balance;
	
	public void withdrow() {
		balance--;
	}
	public void deposit () {
		balance++;
	}

	public Account(int balance) {
		lock = new ReentrantLock();
		this.balance = balance;
	}
	
	
	
}
