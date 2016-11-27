package oct2016.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 11/27/16.
 */
public class Handler {

    List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer a) {
        observers.add(a);
    }

    public void unsubscribe(Observer a) {
        observers.remove(a);
    }

    public void notifySubscribers() {
        for (Observer observer : this.observers) {
            observer.notify();
        }

    }
}
