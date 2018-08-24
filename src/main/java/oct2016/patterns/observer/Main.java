package oct2016.patterns.observer;

/**
 * Created by andrew on 11/27/16.
 */
public class Main {
    public static void main(String[] args) {
        ObserverA Joey = new ObserverA();
        ObserverB Alex = new ObserverB();


        Observable h = new Observable();
        h.subscribe(Joey);
        h.subscribe(Alex);
        h.notify();
    }
}
