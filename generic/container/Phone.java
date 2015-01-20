package generic.container;

public class Phone extends Product<Phone> {
	String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	int subCompare(Phone p) {
		
		return ((Phone)p).getModel().compareTo(this.getModel());
	
	
	}
	
}
