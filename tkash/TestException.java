/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tkash;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author andrew
 */
public class TestException {
	
	public static void doSmth(Integer i) throws MyException {
		if (i==null) {
		throw new MyException("lol");
		}	
	
	}

	public static void write () throws IOException {
		PrintWriter out;
		out = new PrintWriter(new FileWriter("a.txt"));
		out.println("aa");
		out.close();
		}					
}
		

