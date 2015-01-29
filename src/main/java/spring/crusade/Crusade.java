package spring.crusade;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Crusade {

	
	public static void main (String[] arg) {
//		IHetman sagaidach= new Sagaidach();
//		sagaidach.doHike();
		Calendar cal = Calendar.getInstance();
//    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("ss:SS");
    	System.out.println( sdf.format(cal.getTime()) );
		ApplicationContext appCont = new ClassPathXmlApplicationContext("spring/crusade/hetmanConf.xml");
		IHetman hetman= (IHetman) appCont.getBean("crusade");
			System.out.println( sdf.format(cal.getTime()) );
		hetman.doHike();
	
	}
}
