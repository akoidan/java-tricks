package annotat;

@Service(name="simple")
public class SimpleService {
	public SimpleService () {}
	public SimpleService (String name) {
		System.out.println("hello "+name);
		}
	
	@Init
	public void initService(){
		System.out.println("Service has been inited");
	}
	
	
	public void leviyMethod () {
		System.out.println("DOn't call me");
	}
}
