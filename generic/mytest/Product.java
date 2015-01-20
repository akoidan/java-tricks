package generic.mytest;

public abstract class Product <T extends Product> implements Comparable <T> {
	protected String name;
	protected String price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	} 

	public void setPrice(String price) {
		this.price = price;
	}

	abstract int subCompare (T p) ;
	
	@Override
	public int compareTo(T t) {
		int res = name.compareTo(t.name); 
		if  (res==0) {
			res=subCompare(t);
		}
		return res;
	}
	
	
}
