package generic;

import java.util.Collection;
import java.util.List;

public class SomeType {
	
		 public <E> void test(Collection <E> collection) {
			 for (E e: collection) {
				 System.out.println(e);
			 }
		 
		 }
		 
		 public void test (List <Integer> integerList) {
			 for (Integer i:integerList) {
				 System.out.println(i);
			 }
		 }
	 }