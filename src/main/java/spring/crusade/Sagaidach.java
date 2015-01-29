package spring.crusade;

public class Sagaidach implements IHetman{

String name;
String crusades;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCrusades() {
		return crusades;
	}

	public void setCrusades(String crusades) {
		this.crusades = crusades;
	}



	public Sagaidach() {
		this.name = "sagaidach";
	}
	
	
	
@Override
	public void doHike() {
		System.out.println( String.format("Hetman %s went for Hike", name));
	}
	
	
}
