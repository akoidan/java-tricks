package xml.jaxb;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
 
public class JAXBXMLToObject {
	public static void main(String[] args) {
 
	 try {
 
		File file = new File("jaxb.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
		 System.err.println("asd");
//		System.out.println("name =" +customer.getName());
//			System.out.println("age =" +customer.getAge());
//				System.out.println("id =" +customer.getId());
 
	  } catch (JAXBException e) {
		e.printStackTrace();
	  }
 
	}
}