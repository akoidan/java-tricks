  package concurrency;



public class UniqueID {
	public static final ThreadLocal<Integer> id=new ThreadLocal<>();
	public static int getId () {
	 return id.get();
	}
	public static void setId(int iden) {
		id.set(iden);
	}
	
	public static void unset() {
		id.remove();
	}
}
