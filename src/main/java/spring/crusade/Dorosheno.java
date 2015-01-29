package spring.crusade;

public class Dorosheno implements IHetman{

String name;
String crusades;
	public Dorosheno() {
		this.name = "Doroshenk";
	}

	public String getCrusades() {
		return crusades;
	}

	public void setCrusades(String crusades) {
		this.crusades = crusades;
	}
	
	
	
	@Override
	public void doHike() {
		System.out.println( String.format("Hetman %s has gone for a Hike", name));
	}
	
	
}
