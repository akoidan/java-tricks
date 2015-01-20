package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class JenericErrorsTest {

	
    public static void main(String[] args) {
		 cast3();
//		 List rawList = new ArrayList();
//		 List <String> list = new ArrayList<>();
////		 lol2.add();
//		 rawList=list;
//		 rawList.add(8);
//		 Integer asd=2;
//		 
//		 String a;
////		 Integer b = (Integer)a;
////		 s=asd;  
//		 Object s= (Object) list.get(0);
//		 Integer s1= (Integer)s;
    }
	 public static void cast() {
	 
	 SomeType sm= new SomeType(); 
	 List <String> list = Arrays.asList("value");
	 sm.test(list);
	 }
	 
	 public static void cast2() {
//		 List<String> lstr= new ArrayList<>();
//		 List<Object> lobj=lstr;
//		 String s = lstr.get(0);
	 }

	 public static void cast3() {
	 List <String> strList = new ArrayList<>();
	 List <Object> objList = new ArrayList<>();
	 List list = new ArrayList();
	 Object obj = new Object();
	 list.add(obj);
	  print(list);
	 }
	 
	 public static void print(Collection<String> list) {
		 for ( String string : list) {
		  System.out.println(string);
		 }
	 
	 }
	 
}
