package xml.jaxb;


import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
 
public class JAXBObjectToXML {
	public static void main(String[] args) throws IOException {
 
	  Customer customer = new Customer();
//	  customer.setId(100);
	  customer.id=100;
	  customer.setName("mkyong");
	  customer.setAge(29);
	  Deal d = new Deal();
	  d.setName("bekon");
	  d.setPrice(23);
	  customer.setDeal(d);
 
	  try {
 
		File file = new File("jaxb.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 file.createNewFile();
		jaxbMarshaller.marshal(customer, file);
		jaxbMarshaller.marshal(customer, System.out);
		
	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
 
	}
}