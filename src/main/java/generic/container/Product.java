package generic.container;

public abstract class Product <T extends Product<T>> implements IPrice, IName, Comparable<T>{
	String name;
	int price;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int compareTo(T t) {
		if (t.price>this.price) return 1;
		if (t.price==this.price){
			return 0; 
		}else {
			return -1;
		}
	}
	
	abstract int subCompare(T p) ;
	
	
}
