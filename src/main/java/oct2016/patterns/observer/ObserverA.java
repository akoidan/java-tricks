package oct2016.patterns.observer;

/**
 * Created by andrew on 11/27/16.
 */
public class ObserverA implements Observer {
    @Override
    public void onNotify() {
        System.out.println("A is notified");
    }
}
