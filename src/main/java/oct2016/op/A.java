package oct2016.op;

/**
 * Created by andrew on 11/26/16.
 */
public class A {

    private int lol = 5;

    public static void main(String[] args) {
        new AInn();

        new A().new AInnNS().print();
    }
    static void koko() {
    }

    protected A doSmth (B a) throws Exception {
        System.out.println("DO");
        return null;
    }

    class AInnNS {
        void print() {
            System.out.println(lol);
            System.out.println("O");
        }
    }

    static class AInn {
        void print() {
            System.out.println("O");
        }
    }
}
