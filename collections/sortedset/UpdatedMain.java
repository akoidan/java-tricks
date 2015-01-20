 package collections.sortedset;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class UpdatedMain {
		
	 NavigableSet <Integer> sortedSet;
    public static void main(String[] args) {
		  UpdatedMain main = new UpdatedMain();
		
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
		 return sortedSet.higher(elem);
	 }
	 
		SortedSet<Integer> getPrevElems(Integer elem) {
//		 SortedSet<Integer> newSortedSet= new TreeSet<>();
		return sortedSet.headSet(elem);
	 
	 }
	 
	 
}
