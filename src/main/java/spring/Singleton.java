package spring;



public class Singleton implements ToString{

	private String message;

	@Override
	public String toString() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	private static Singleton instance;
	private Singleton(){
	}

	public static Singleton getInstance() {
		if (Singleton.instance==null) {Singleton.instance= new Singleton();}
			return instance ;
		}

	
	}
	
	
	

