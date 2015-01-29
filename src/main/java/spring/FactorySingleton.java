package spring;

public class FactorySingleton {
	public ToString getToString() {
		Singleton lol = Singleton.getInstance();
		lol.setMessage("created by FactorySingleton");
		return lol;
	
	
	}
}
