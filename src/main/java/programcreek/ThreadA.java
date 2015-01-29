package programcreek;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadA {
	
	
    public static void main(String[] args){
		  Object synObject= new Object();
        ThreadB b = new ThreadB("b",synObject,200);
        ThreadB c = new ThreadB("c",synObject,1000);
		  b.start();
		  c.start();
        synchronized(synObject){
            try{
                System.out.println("Waiting for b to complete...");
					 synObject.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Total is: " + b.total);
        }
    }
}
 
class ThreadB extends Thread{
	
	public String message;
	Object synObject;
	int countTO;

	public ThreadB(String lol, Object synObject,int countTO ) {
		this.synObject= synObject;
		message = lol;
		this.countTO=countTO;
	}
    int total;
    @Override
    public void run(){
		 System.out.println("Joined to this thread");
		try {
			
			Thread.sleep(10000);
		} catch (InterruptedException ex) {
			Logger.getLogger(ThreadB.class.getName()).log(Level.SEVERE, null, ex);
		}
        synchronized(synObject){
//			  if (countTO==200)	notify(); else try {
//				  synObject.wait();
//			  } catch (InterruptedException ex) {
//				  Logger.getLogger(ThreadB.class.getName()).log(Level.SEVERE, null, ex);
//			  }
			 
			   System.out.println("Thread B started" + message);
            for(int i=0; i<countTO ; i++){
                total += i;
            }
				System.out.println("Thread B Finished"+message);
		 synObject.notify();
    }
	 }
}