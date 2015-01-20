package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyNewThread implements Runnable{

	private boolean stop;

	Object lock;
	public MyNewThread() {
		lock = new Object();
		this.stop = false;
	}
	
	public MyNewThread(Object lock) {
		this.lock =lock;
		this.stop = false;
	}
	
	public void stop (){
	stop = !stop;
	}
	@Override
	public void run() {
		int i=0;
		
		synchronized(this){
		while (!stop) {
					 try {
				 Thread.sleep(1000);
				 System.out.println(i);
				 i++;
//				 if (i==3)this.wait();
			} catch (InterruptedException ex) {
				Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
				}
	}}
	}
   
}
