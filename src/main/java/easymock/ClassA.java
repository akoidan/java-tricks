package easymock;

import annotat.Service;

public class ClassA implements InterfaceA{

//	@Service(name="lol")
	@Override
	public String sayHello() {
		System.out.println("hello");
		return "hello";
	}
	
}
