package xml.jaxb;

 
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Customer {
 
//	@XmlElement
	Deal deal;
	
	String name;
	int age;
	
//	@XmlAttribute
	 int id;

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}
 
	
	
	public String getName() {
		return name;
	}
 
//	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
 
	public int getAge() {
		return age;
	}
 
//	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}
 
//	@XmlAttribute
	public int getId() {
		return id;
	}
 
//	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
 
}