package spring;

public class Message implements ToString{
	String message;
	int lol=5;
	public Message(String message, int type) {
		this.lol=type;
		this.message = message;
	}

	public Message(String message, String type) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return message+lol;
	}
	

}
