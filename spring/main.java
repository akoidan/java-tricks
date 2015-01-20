package spring;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

    public static void main(String[] args) throws InterruptedException {
		
		 ApplicationContext context = 
             new ClassPathXmlApplicationContext("spring/List.xml");
		 System.out.println("app context is created");
		  Service service=(Service) context.getBean("testList");
		  List lol =service.getMyLol();
		  for (Object object : lol) {
			  System.out.println(object);
		 }
		 context=null;
      lol = null;
		 System.gc() ;
		 Thread.sleep(10000);
		 System.out.println("program finished");
//      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
//      obj.getMessage();
    }

}
