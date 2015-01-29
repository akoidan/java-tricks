package generic.mytest;

public class Phone extends Product<Phone> {

	String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
//	
//	@Override
//	public int compareTo(Phone t) {
//		return model.compareTo(t.model);
//	}

	@Override
	int subCompare(Phone p) {
		return 1;
	}
	
}
