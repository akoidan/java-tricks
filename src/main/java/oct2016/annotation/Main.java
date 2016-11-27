package oct2016.annotation;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

@MyAnnot(name = "asd")
public class Main implements Serializable {

    public void koko() {

    }
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("oct2016.annotation.A");
        A a  = (A) aClass.newInstance();
        showInit(a);

    }

    private static void showInit(A a) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        inspectService(a.getClass());
        Class<?> myClass = Class.forName("oct2016.annotation.A");
        System.out.println(myClass);
        Modifier.isPublic(myClass.getModifiers());
        System.out.printf("Interfaces: %s\n", myClass.getInterfaces().toString());
        System.out.println();
        System.out.print("Parent fields:" );
        Arrays.stream(myClass.getFields()).forEach(num -> System.out.print(num.getName()));
        System.out.println();
        System.out.printf("Methods and private : %s\n", myClass.getDeclaredMethods());

        System.out.printf("Superclass of %s is: %s\n",myClass.getSimpleName(), myClass.getSuperclass());
        for (Method method : a.getClass().getDeclaredMethods()) {
            InitAnnotation annotation = method.getAnnotation(InitAnnotation.class);
            if (annotation != null) {
                System.out.printf(
                        "Method %s marked as initMethod, exception are %s suppressed",
                        method.getName(),
                        annotation.suppressException() ? "": "not");
                try {
                    method.setAccessible(true);
                    method.invoke(a, 3);

                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    if (!annotation.suppressException()) {
                        throw e;
                    }
                }
            }
        }
    }

    static void inspectService(Class<?> service) {
        MyAnnot annotation = service.getAnnotation(MyAnnot.class);
        if (annotation != null) {
            System.out.println(annotation.name());
        } else {
            System.err.println("NOT oct2016.annotation.A SERVICE");
        }
    }
}
