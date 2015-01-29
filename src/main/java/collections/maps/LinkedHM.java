package collections.maps;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHM {

    public static void main(String[] args) {
		 HashMap<Integer,String> hashMap= new LinkedHashMap<>();
		  hashMap.put(5,"5");
		  hashMap.put(34,"4");
		  hashMap.put(3,"3");
		  hashMap.put(2,"2");
		  hashMap.put(1,"1");
		  System.out.println(hashMap);
    }

}
