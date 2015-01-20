package generic.container;

import java.util.List;

public class Container <T extends Product & IName & IPrice > {
	T item;
//
//	boolean find (List <? extends Product> all, Product p) {
//		return false;
//	}
	
<X extends Product> boolean find(List <X> all, X p) {
	return false;
}	

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
	
}
