package patterns;

import java.util.ArrayList;
import java.util.List;

public class Obs2 {
    public static void main(String[] args) {
        Subject observer = new Subject();
        S1 s1 = new S1(observer, "s1");
        S1 s2 = new S1(observer, "s2");
        s1.setPrice(123);
    }


    static class Subject {
        List<Observable> observables = new ArrayList<>();
        public void add(Observable a) {
            observables.add(a);
        }
        public void remove(Observable a) {
            observables.remove(a);
        }
        public void notifyAllObseravles(Observable a) {
            for (Observable observable : observables) {
                observable.update(a);
            }

        }
    }

    static class S1 implements Observable {

        private final Subject s;
        private final String name;

        S1(Subject s, String name) {
            this.s = s;
            this.name = name;
        }

        private int price;

        @Override
        public void update(Observable a) {
            System.out.println("Name: "+ name + " got notified that object " + a + " is updated");
        }

        void setPrice(int price) {
            this.price = price;
            s.notifyAllObseravles(this);
        }

        @Override
        public String toString() {
            return "S1{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


    interface Observable {
        void update(Observable a);
    }
}
