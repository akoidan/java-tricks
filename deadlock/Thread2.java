package myapplication;

class Thread2 extends java.lang.Thread {
    int k = 5;
    int l = 120;
    int number;
    final Object myLock1;
    final Object myLock2;
    
    public Thread2(Object myLock1, Object myLock2) {
        this.myLock1 = myLock1;
        this.myLock2 = myLock2;
        setName("MyThread2");
    }
    
    @Override
    public void run() {
        synchronized(myLock1) {
            init();
            doMyJob4();
            synchronized(myLock2) {
                doMyJob5();
            }
        }
        
        System.out.println(getName() + " successfully finished.");
    }
    
    public void init() {
        number = 10;
    }
    
    public void doMyJob4() {
        number += 5;
    }
    
    public void doMyJob5() {
            number++;
    }
    
}
