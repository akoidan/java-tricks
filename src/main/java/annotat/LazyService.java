 package annotat;


@Service(name="lazy")
public class LazyService {
	
	@Override
	public String toString () {
	return "LazyService";
	}
	@Init
	public void lazyInit() throws Exception {
		System.out.println("Service has been lazy inited");
	
	}
}
