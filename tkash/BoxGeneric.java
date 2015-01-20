package tkash;

public class BoxGeneric<T extends Integer> {

	public BoxGeneric() {
		T dss;
		dss= (T) new Integer(2);
	}
	
	public static <K extends String,H extends Number ,L extends Number> K lol (H item1, L item2 ) {
		return (K) (""+item1+item2);
		
	}	
	
	private T b;

	public T getB() {
		return b;
	}

	public void setB(T b) {
		this.b = b;
	}

	
}
