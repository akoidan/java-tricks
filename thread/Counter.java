package thread;

public class Counter {

int c=0;
Object lock= new Object();
 public  void inc(){
	 synchronized (lock){
		  
	 c++;
	 }
 }
 
public  void dec() {
c--;}
}
