package collections.threadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

public class ReadList implements Callable <Long> {

	private List<Integer> list;
	private CyclicBarrier cb;

	public ReadList(List list, CyclicBarrier cb) {
		this.cb = cb;
		this.list= list;

	}

	@Override
	public Long call() throws Exception {
		//wait untill all threads start
		System.out.println("Joined to Thread");
		cb.await();
		System.out.println("Thread has started executing");
		Long startTime = System.currentTimeMillis();
		//read all the list
		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}
		Long stopTime = System.currentTimeMillis();
      Long elapsedTime = stopTime - startTime;
//		System.out.println(elapsedTime);
		return elapsedTime;
	}

	
	
	
	
	
}
