package collections.threadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//import static javax.swing.text.html.HTML.Tag.S;

public class MyCopyOnWriteArrayListSpeedTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
		 List <Integer> cowal = new CopyOnWriteArrayList<>();	 
		 List sychrList = Collections.synchronizedList(new ArrayList<Integer>());	 
		 for (int i = 0; i < 10000; i++) {
			 cowal.add(i);
			 sychrList.add(i);
		 }

		CyclicBarrier cb = new CyclicBarrier(3);
		ExecutorService es=  Executors.newFixedThreadPool(3);
			
		//Syncrh TIme
		ReadList synchrThread1 = new ReadList(sychrList, cb);
		ReadList synchrThread2 = new ReadList(sychrList, cb);
		ReadList synchrThread3 = new ReadList(sychrList, cb);
		
		Future<Long> futureTimeSycnr1 = es.submit(synchrThread1);
		Future<Long> futureTimeSycnr2 = es.submit(synchrThread2);
		Future<Long> futureTimeSycnr3 = es.submit(synchrThread3);
		
		
//		Thread.sleep(10000);   
	
		
//		 System.out.println("__________");
//		 Thread.sleep(3000);

		 System.out.println(String.format("Synch: %d ; %d ; %d", futureTimeSycnr1.get(), futureTimeSycnr2.get(),futureTimeSycnr3.get()));
		 CyclicBarrier cb2 = new CyclicBarrier(3);
		 	//Syncrh TIme
		ReadList cowalThread1 = new ReadList(cowal, cb2);
		ReadList cowalThread2 = new ReadList(cowal, cb2);
		ReadList cowalThread3 = new ReadList(cowal, cb2);
		
		Future<Long> futureTimeCowal1 = es.submit(cowalThread1);
		Future<Long> futureTimeCowal2 = es.submit(cowalThread2);
		Future<Long> futureTimeCowal3 = es.submit(cowalThread3);
		
//		Thread.sleep(10000);
	
		

		 System.out.println(String.format("Cowal: %s ; %s ; %s", futureTimeCowal1.get(), futureTimeCowal2.get(),futureTimeCowal1.get()));
		 
		 
		 
		 es.shutdown();
		
    }

}
