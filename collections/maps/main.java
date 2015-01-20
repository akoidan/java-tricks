package collections.maps;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//		 Map<Integer,String> myMap = new  HashMap<>();
      HashMap<Integer, Integer> lol = new HashMap<>(3);
      for (int a = 1; a< 14; a++) {
        lol.put(a,a);
      }
      lol.put(28,15);
      int a =  1 << 4;
      System.out.println(a);

      System.out.println(a);
      System.out.println("capacity");
      Method capacity = HashMap.class.getDeclaredMethod("capacity");

      if(!capacity.isAccessible()) {
        capacity.setAccessible(true);
      }
      Object invoke = capacity.invoke(lol);

      System.out.println(lol);
      Map<Object, Integer> myMap = new SimpleLRUCache<>(2);
		 Object obj= new Object();
		 myMap.put(obj, 1);
		 obj= null;


		 System.out.println(myMap);
		 
	 }

}
