package myapplication;

class Thread1 extends java.lang.Thread {
    int i = 10;
    int j = 20;
    int number;
    final Object myLock1;
    final Object myLock2;
    
    public Thread1(Object myLock1, Object myLock2) {
        this.myLock1 = myLock1;
        this.myLock2 = myLock2;
        setName("MyThread1");
    }
   
    @Override
    public void run() {
        synchronized(myLock2) {
            init();
            doMyJob1();
            synchronized(myLock1) {
                if (i > j) {
                    doMyJob2();
                } else {
                    doMyJob3();
                }
            }
        }
        System.out.println(getName() + " successfully finished");
    }
    
    public void init() {
        number = 10;
    }
    
    public void doMyJob1() {
        number += 5;
    }
    
    public void doMyJob3() {
        synchronized(myLock1) {
            number++;
        }
    }
    
    public void doMyJob2() {
        number -= 6;
    }
    
}

