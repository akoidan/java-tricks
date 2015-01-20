/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sethashequals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
// *
 * @author andrew
 */
public class SetHashEquals {

    /**
     * @param args the command line arguments
     */ 
   @Autowired
   @Qualifier("id1")
    private HelloSpring springEx;

    public HelloSpring getSpringEx() {
        return springEx;
    }

    public void setSpringEx(HelloSpring springEx) {
        this.springEx = springEx;
    }
   
    
    public static void main(String[] args) throws IOException, InterruptedException {
         ApplicationContext appContext = new FileSystemXmlApplicationContext("file:/home/andrew/NetBeansProjects/SetHashEquals/spring-context.xml"); 
//                 String[] cmd = { "pwd" };
//        Process p = Runtime.getRuntime().exec(cmd);
//        p.waitFor();
//        
//        Process process = new ProcessBuilder("pwd").start();
//InputStream is = process.getInputStream();
//InputStreamReader isr = new InputStreamReader(is);
//BufferedReader br = new BufferedReader(isr);
//String line;
//
//System.out.printf("Output of running %s is:", Arrays.toString(args));
//
//while ((line = br.readLine()) != null) {
//  System.out.println(line);
//}
        
        SetHashEquals main= appContext.getBean(SetHashEquals.class);
        main.springEx.sayHello();


    }

}
