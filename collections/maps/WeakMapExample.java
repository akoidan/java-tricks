  package collections.maps;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakMapExample {

    public static void main(String[] args) throws InterruptedException {
		 Map <Object,String> map = new  WeakHashMap<>();
		 Object i = new Object();
		 map.put(i, "info"); 
		 i=null;
		 System.gc();
//		 Thread.sleep(1000);
		 for (int i2=1; i2<1000000; i2++) {
			 if (map.isEmpty()) {
				 System.out.println("empyy!"+i2);
				 break;
			 }
		 }
    }

}
