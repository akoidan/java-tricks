 package generic.container;

import java.util.List;

public class Main {

	public static void main (String[] arg) {
		doesntwork();
		List <Camera> prod = null;
		List <Product > object = null;
		Camera cam = new Camera();
		Phone ph = new Phone();
//		cam.c
//		copy1(prod, object);

	}
	
	 static void copy1 (List <? extends Product> src, List <? super  Product>  dest) {
		for (Product p: src) {
		dest.add(p);  
		}
	}
	
	
	 <T extends Product>  void copy (List <T> src, List <T>  dest) {
		for (T p: src) {
		dest.add(p);  
		}
	}
	
	private static void doesntwork() {
//				Container<Camera> sdf=null;
//		List <Camera> cameras=null;
//		sdf.find(cameras,new Phone());
	}
}
