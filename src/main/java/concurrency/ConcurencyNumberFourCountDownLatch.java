package concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import javax.naming.InsufficientResourcesException;

public class ConcurencyNumberFourCountDownLatch {
	public static void main (String arv[]) throws InterruptedException, InsufficientResourcesException {
	final AtomicInteger failcount = new AtomicInteger(0);
	final  Account a= new Account(1000);
	final  Account b= new Account(2000);

		CountDownLatch countDownLatch = new CountDownLatch(1);
		ExecutorService service = Executors.newFixedThreadPool(3);
	
	for (Integer i=0; i<10; i++) {
		
//		new Thread(new TransferForCDL(a, b, new Random().nextInt(40), i, failcount, countDownLatch)).start();
		service.submit(new TransferForCDL(a, b, new Random().nextInt(40),i,failcount,countDownLatch));
//		new TransferForCDL(a, b, new Random().nextInt(40),i,failcount,countDownLatch).call();
	}		
		System.out.println("main Thread has slept");
	Thread.sleep(1000);
	
		System.out.println("main Thread has waken up");
		countDownLatch.countDown();
	}
}
