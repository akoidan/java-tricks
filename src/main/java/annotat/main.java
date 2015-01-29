package annotat;

import java.lang.annotation.Retention;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

	public static Map <String, Object> map;
    public static void main(String[] args)  {
		 
//		 invokeMethod("annotat.LazyService","toString");
//		map = new HashMap<>();
//		 loadService("annotat.LazyService");
//		 loadService("annotat.SimpleService");
//		 loadService("java.lang.String");
//		 System.out.println(((LazyService)map.get("annotat.LazyService")));
		 
//		 createInstance();
		inspectService(Service.class);
		inspectService(SimpleService.class);
		inspectService(LazyService.class);
		inspectService(String.class);
//		String sdf = "asd";
//		Class.
//		Class asdsdfds =String.class;
		
//	St
//		
    }

	 public static void invokeMethod (String classname, String classMethod) {
	 
		try {
			Class clazz= Class.forName(classname);
			Method m= clazz.getMethod(classMethod);
			Object obj =clazz.newInstance();
			System.out.println(m.invoke(obj, null));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		 
	 } 
	 public static void loadService (String name) {
		try {
			Class clazz= Class.forName(name);
			if (clazz.isAnnotationPresent(Service.class)){
				Object lol =clazz.newInstance();	
				map.put(name, lol);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	 }
	 static void createInstance ()  {
		String name="annotat.SimpleService"; // remove package
		Class ss=null;
		 try {
			 ss = Class.forName(name);
			 Constructor constructor = ss.getConstructor(String.class);
			 constructor.newInstance("lol");
//			 SimpleService simpleservice = (SimpleService) ss.newInstance();
			 
		 } catch (Exception ex) {
			ex.printStackTrace();
		}
	 }
	 
	 static void inspectService (Class<?> service) { 
		
//		 System.out.println( service.isAnnotationPresent(Retention.class));
		 System.err.println("1");
		 
		 for (Method method : service.getDeclaredMethods()) {
			if (method.isAnnotationPresent(Init.class)) {
				System.out.println("class: "+service.getName()+" with method: "+method.getName()+" has annotation"+" Init");
			}
		 }
		 
		  System.err.println("2");
		  
		 if(service.isAnnotation()) System.out.println(service+" is annotation class");
		 if(service.isAnnotationPresent(Service.class)) {
		
		  Service myAnnotation = service.getAnnotation(Service.class);

		  StringBuilder stringBuilder = new StringBuilder();
		  stringBuilder.append("class").append(service).append("has annotation @Service and name=").append(myAnnotation.name());
		   System.out.println(stringBuilder);
		 } else
		  {System.out.println("Class"+service+" hasn't annotation @Service");}
		 
	 }
}
