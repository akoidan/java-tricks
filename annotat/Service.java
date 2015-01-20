/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package annotat;

import java.lang.annotation.*;


/**
 *
 * @author andrew
 */
@Documented//javaDoc
@Inherited //all subcluses inherites this annotation
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
	String name();
	boolean lazyLoad() default false;
}
