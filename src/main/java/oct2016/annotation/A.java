package oct2016.annotation;

/**
 * Created by andrew on 11/26/16.
 */
public class A extends Main {

    @InitAnnotation(suppressException = true)
    private int initMethod(Integer b) {

        @MyVarAnnot()
        Integer a = 0;
        if (b == null) {
            throw new IllegalArgumentException();
        }

        int res = a + b;
        System.out.printf("REsult %d", res);
        return res;
    }

    public void doSmth() {
        System.out.println("smth");
    }

}
