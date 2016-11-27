package oct2016.op;

/**
 * Created by andrew on 11/26/16.
 */
public class B extends A {

    static void koko() {
        int a = 3;
        assert a == 3;

    }

    @Override
    public B doSmth (B a) throws MyExc, MyExc, Exception, MyExc2 {
        System.out.println("DO");

        return null;
    }

    public static void main(String[] args) {
        try{
//            Map.class.isAssignableFrom()
            String s = "asda";
            String b =  new String("asda").intern();
            System.out.println(s == b);
            throw new Error("asd");
        } catch (Exception e) {

//        } catch (MyExc2 e) {

        }finally {
            System.out.println('d');
        }
    }

}
