package concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.InsufficientResourcesException;

public class TransferForCDL  implements Callable {

	Account accountFrom;
	Account accountTo;
	int amount;
	private AtomicInteger failCount;
	private CountDownLatch countDownLatch;
	


	public TransferForCDL(Account accountFrom, Account accountTo, int amount, int identification,
		AtomicInteger failCount, CountDownLatch cdl) {
		this.accountFrom = accountFrom;
		this.accountTo = accountTo;
		this.amount = amount;
		this.failCount=failCount;
		this.countDownLatch= cdl;
		MyThreadLocal.set(identification);
	}





	@Override
	public Object call()  {
			
//		ThreadLocal.
//		System.out.println(ThreadLocal.);
		System.out.println(MyThreadLocal.get());
		try {
			countDownLatch.await();
		} catch (InterruptedException ex) {
//			Logger.getLogger(TransferForCDL.class.getName()).log(Level.SEVERE, null, ex);
		}
		
//		accountFrom.getLock().tryLock();
		String transfered= "fail";
		while (transfered.equals("fail")) {

//			failCount.intValue();
//		if (accountFrom.getBalance()<amount) throw  new InsufficientResourcesException("not enough balance");
		try {/* if lock A is busy and Thread is interrapted while waitig 1 second 
			a.getLock().tryLock(1, TimeUnit.SECONDS must be processed
			*/
			if (accountFrom.getLock().tryLock(1, TimeUnit.SECONDS)) {
				
				try { // If inner code of A.lock fail
//					System.out.println("try");
					System.out.println("Logged into a: " +accountFrom+" "+System.currentTimeMillis());	
					if (accountTo.getLock().tryLock(1, TimeUnit.SECONDS)) {
						try { //Execute transfer exception
							System.out.println("Logged into b: " +accountTo+" "+System.currentTimeMillis());
							accountFrom.withdraw(amount);
							accountTo.deposit(amount);
							Thread.sleep(new Random().nextInt(1000));
							transfered="succeded"+System.currentTimeMillis();
						} catch (Exception e) {
							System.err.println("Exception on execute transfer operation = "+e+" " +System.currentTimeMillis());
						} finally {
							accountTo.getLock().unlock();
						}
					} else {
						System.err.println(accountTo.toString()+" (b) is locked "+System.currentTimeMillis());
					}
				}catch (Exception e) {
					System.err.println("Something fail inside of locked A"+System.currentTimeMillis());
				} finally {
					accountFrom.getLock().unlock();
				}
			} else {
				System.err.println(accountFrom.toString()+" (a) is locked"+System.currentTimeMillis());
			}
		} catch (Exception ex) {
			System.err.println("Lock waiting has been interrupted"+ex);
		} 
		StringBuilder builder= new StringBuilder();
		builder.append("transfer ").append(accountFrom).append(" to ").append(accountTo).append(" ").append(transfered);
		if (transfered.equals("fail")) {
			failCount.incrementAndGet();
//			return false;
		} else {
			System.out.println(builder);
			break;
		}
		}
//		return true;
		return null;
	}

	


 
}
