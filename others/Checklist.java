/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package checklist;

import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author andrew
 */
public class Checklist {
    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        
        try {
            String a= "3";
            a.toString().toString().toString();
            
            System.out.println("1");
            return ;
            //TODO is finally executed when return??
        } catch (Exception e) {
            
        } finally {
            System.out.println("2");
        }
        
        
        
    }
    
    
}
