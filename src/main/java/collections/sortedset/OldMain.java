package collections.sortedset;

import java.util.SortedSet;
import java.util.TreeSet;

public class OldMain {
		
	 SortedSet<Integer> sortedSet;
    public static void main(String[] args) {
		  OldMain main = new OldMain();
		
		 main.sortedSet= new TreeSet<Integer>();	  
		 for (int i=0;i<9;i++) {
		 main.sortedSet.add(i+1);
		 }

		 
		  for (Integer el: main.getPrevElems(4)) {
			  	 System.out.println(el);
		 } 
		  
	
		 System.out .println(main.getNextElem(2));
    }

	 
	 Integer getNextElem(Integer elem) {
		 boolean check = false;  
		 Integer result=null;
		 for (Integer el: sortedSet) {
			  if (check) {result=el; break;}
			 if (el.equals(elem)) {
			 check= true;
			 }
		 }
		 return result;
	 }
	 
	 SortedSet<Integer> getPrevElems(Integer elem) {
		 SortedSet<Integer> newSortedSet= new TreeSet<>();
		 for (Integer el: sortedSet) {
			 if (el.equals(elem)) break;
			 newSortedSet.add(el);
		 } 
		 return newSortedSet;
	 }
	 
	 
}
