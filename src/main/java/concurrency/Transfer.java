package concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.naming.InsufficientResourcesException;

public class Transfer implements Callable<Boolean> {

	Account accountFrom;
	Account accountTo;
	int amount;
	UniqueID id;
	private AtomicInteger failCount;
	
	public Transfer() {
	}

	public Transfer(Account accountFrom, Account accountTo, int amount, int id, AtomicInteger failCount) {
		this.accountFrom = accountFrom;
		this.accountTo = accountTo;
		this.amount = amount;
		this.failCount=failCount;
		UniqueID.setId(id);
	}



	@Override
	public Boolean call() throws InsufficientResourcesException{
		
		
//		accountFrom.getLock().tryLock();
		String transfered= "fail";
		while (true) {
//			failCount.intValue();
		if (accountFrom.getBalance()<amount) throw  new InsufficientResourcesException("not enough balance");
		try {/* if lock A is busy and Thread is interrapted while waitig 1 second 
			a.getLock().tryLock(1, TimeUnit.SECONDS must be processed
			*/
			if (accountFrom.getLock().tryLock(1, TimeUnit.SECONDS)) {
				try { // If inner code of A.lock fail
					System.out.println(id+"Logged into a: " +accountFrom+" "+System.currentTimeMillis());	
					if (accountTo.getLock().tryLock(1, TimeUnit.SECONDS)) {
						try { //Execute transfer exception
							System.out.println(id+"Logged into b: " +accountTo+" "+System.currentTimeMillis());
							accountFrom.withdraw(amount);
							accountTo.deposit(amount);
							Thread.sleep(new Random().nextInt(1000));
							transfered="succeded"+System.currentTimeMillis();
						} catch (Exception e) {
							System.err.println(id+"Exception on execute transfer operation = "+e+" " +System.currentTimeMillis());
						} finally {
							accountTo.getLock().unlock();
						}
					} else {
						System.err.println(id+accountTo.toString()+" (b) is locked "+System.currentTimeMillis());
					}
				}catch (Exception e) {
					System.err.println(id+"Something fail inside of locked A"+System.currentTimeMillis());
				} finally {
					accountFrom.getLock().unlock();
				}
			} else {
				System.err.println(id+accountFrom.toString()+" (a) is locked"+System.currentTimeMillis());
			}
		} catch (Exception ex) {
			System.err.println(id+"Lock waiting has been interrupted"+ex);
		} 
		StringBuilder builder= new StringBuilder();
		builder.append(id).append("transfer ").append(accountFrom).append(" to ").append(accountTo).append(" ").append(transfered);
		if (transfered.equals("fail")) {
			failCount.incrementAndGet();
//			return false;
		} else {
			System.out.println(builder);
			return true;
		}
		}
	}
 
}
