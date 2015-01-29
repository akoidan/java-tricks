/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sethashequals;

import org.springframework.stereotype.Component;

/**
 *
 * @author andrew
 */
@Component
public class HelloSpring {

    public HelloSpring(String a) {
        this.a = a;
    }
    
    
    public void sayHello () {
        System.out.println(a);
    }
    private String a;
    
    
    
}
