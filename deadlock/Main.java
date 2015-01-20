package myapplication;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Application started");
        
        Object myLock1 = new Object();
        Object myLock2 = new Object();
        
        new Thread1(myLock1, myLock2).start();
        new Thread2(myLock1, myLock2).start();
        
        Thread.sleep(500000);
        System.out.println("Main thread finished");
    }
    
}
