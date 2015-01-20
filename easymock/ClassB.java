package easymock;

public class ClassB {
	InterfaceA methodToCall;

	public InterfaceA getMethodToCall() {
		return methodToCall;
	}

	public void setMethodToCall(InterfaceA methodToCall) {
		this.methodToCall = methodToCall;
	}
	
	public  String main() {
	methodToCall.sayHello();
	 return null;
	}
}
