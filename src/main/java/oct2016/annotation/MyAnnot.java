package oct2016.annotation;

import java.lang.annotation.*;

/**
 * Created by andrew on 11/26/16.
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnot {

    String name();

    boolean lazyload() default false;
}
